package com.netcetera.codecamp2017.mapper;

import com.netcetera.codecamp2017.domain.ProjectEntity;
import com.netcetera.codecamp2017.domain.TaskEntity;
import com.netcetera.codecamp2017.type.Project;
import com.netcetera.codecamp2017.type.Task;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public List<TaskEntity> mapToEntities(List<Task> tasks) {
        return tasks
            .stream()
            .map(this::mapToEntity)
            .collect(Collectors.toList());
    }

    public TaskEntity mapToEntity(Task task) {

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(task.getId());
        taskEntity.setName(task.getName());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setPriority(task.getPriority());
        taskEntity.setTaskStatus(task.getTaskStatus());
        try{
            Date date = simpleDateFormat.parse(task.getDateScheduled());
            taskEntity.setDateScheduled(date);
        }
        catch (ParseException p){
            System.out.println(p.getMessage());
        }
        return taskEntity;
    }

    public List<Task> mapFromEntities(List<TaskEntity> taskEntities) {

        return taskEntities
            .stream()
            .map(this::mapFromEntity)
            .collect(Collectors.toList());
    }

    public Task mapFromEntity(TaskEntity taskEntity) {

        Task task = new Task();
        task.setId(taskEntity.getId());
        task.setName(taskEntity.getName());
        task.setDescription(taskEntity.getDescription());
        task.setPriority(taskEntity.getPriority());
        task.setTaskStatus(taskEntity.getTaskStatus());
        String date = simpleDateFormat.format(taskEntity.getDateScheduled());
        task.setDateScheduled(date);

        // TODO gcvetano 2017-10-08: there already is a mapper, but qutowiring it will cause circular dependency
        // find a way how to use it
        final ProjectEntity projectEntity = taskEntity.getProject();

        final Project project = new Project();
        project.setName(projectEntity.getName());
        project.setDescription(projectEntity.getDescription());
        task.setProject(project);

        return task;
    }
}
