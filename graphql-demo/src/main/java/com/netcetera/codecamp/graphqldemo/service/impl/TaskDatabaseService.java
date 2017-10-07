package com.netcetera.codecamp.graphqldemo.service.impl;

import com.netcetera.codecamp.graphqldemo.domain.TaskEntity;
import com.netcetera.codecamp.graphqldemo.mapper.TaskMapper;
import com.netcetera.codecamp.graphqldemo.repository.TaskRepository;
import com.netcetera.codecamp.graphqldemo.service.TaskService;
import com.netcetera.codecamp.graphqldemo.type.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskDatabaseService implements TaskService {

    private TaskMapper taskMapper;
    private TaskRepository taskRepository;

    @Autowired
    public TaskDatabaseService(TaskMapper taskMapper, TaskRepository taskRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll() {

        final List<TaskEntity> allTasks = taskRepository.findAll();
        return taskMapper.mapFromEntities(allTasks);
    }

    @Override
    public Task getById() {
        return null;
    }

    @Override
    public Task save(Task task) {

        final TaskEntity taskEntity = taskMapper.mapToEntity(task);
        final TaskEntity savedTaskEntity = taskRepository.save(taskEntity);
        return taskMapper.mapFromEntity(savedTaskEntity);
    }

    @Override
    public void deleteById(String id) {

    }
}
