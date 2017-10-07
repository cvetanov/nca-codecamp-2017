package com.netcetera.codecamp.graphqldemo.mapper;

import com.netcetera.codecamp.graphqldemo.domain.TaskEntity;
import com.netcetera.codecamp.graphqldemo.type.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

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
        taskEntity.setDateScheduled(task.getDateScheduled());
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
        task.setDateScheduled(taskEntity.getDateScheduled());
        return task;
    }
}
