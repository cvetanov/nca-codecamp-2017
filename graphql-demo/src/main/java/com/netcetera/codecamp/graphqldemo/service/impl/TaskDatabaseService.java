package com.netcetera.codecamp.graphqldemo.service.impl;

import com.netcetera.codecamp.graphqldemo.domain.ProjectEntity;
import com.netcetera.codecamp.graphqldemo.domain.TaskEntity;
import com.netcetera.codecamp.graphqldemo.enumeration.TaskStatus;
import com.netcetera.codecamp.graphqldemo.mapper.TaskMapper;
import com.netcetera.codecamp.graphqldemo.repository.ProjectRepository;
import com.netcetera.codecamp.graphqldemo.repository.TaskRepository;
import com.netcetera.codecamp.graphqldemo.service.TaskService;
import com.netcetera.codecamp.graphqldemo.type.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskDatabaseService implements TaskService {

    private TaskMapper taskMapper;

    private TaskRepository taskRepository;

    private ProjectRepository projectRepository;

    @Autowired
    public TaskDatabaseService(TaskMapper taskMapper, TaskRepository taskRepository,ProjectRepository projectRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
        this.projectRepository=projectRepository;
    }

    @Override
    public List<Task> getAll() {

        final List<TaskEntity> allTasks = taskRepository.findAll();
        return taskMapper.mapFromEntities(allTasks);
    }

    @Override
    public Task getById(Long id) {
        final TaskEntity taskEntity = taskRepository.findOne(id);
        return taskMapper.mapFromEntity(taskEntity);
    }

    @Override
    public Task save(Task task) {

        if(!task.getDateScheduled().equals(Task.DEFAULT_DATE)){
            task.setTaskStatus(TaskStatus.SCHEDULED);
        }
        final TaskEntity taskEntity = taskMapper.mapToEntity(task);

        ProjectEntity projectEntity = projectRepository.findOne(1L);
        taskEntity.setProject(projectEntity);

        final TaskEntity savedTaskEntity = taskRepository.save(taskEntity);
        return taskMapper.mapFromEntity(savedTaskEntity);
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<Task> getAllByStatus(TaskStatus taskStatus) {
        return taskMapper.mapFromEntities(taskRepository.findByTaskStatus(taskStatus));
    }

    @Override
    public List<Task> getAllByDateScheduled(Date date) {
        return taskMapper.mapFromEntities(taskRepository.findAllByDateScheduled(date));
    }
}
