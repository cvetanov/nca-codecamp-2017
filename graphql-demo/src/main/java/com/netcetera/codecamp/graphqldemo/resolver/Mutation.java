package com.netcetera.codecamp.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.netcetera.codecamp.graphqldemo.service.TaskService;
import com.netcetera.codecamp.graphqldemo.type.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private TaskService taskService;

    @Autowired
    public Mutation(TaskService taskService) {
        this.taskService = taskService;
    }

    public Task addTask(Task task) {
        return taskService.save(task);
    }
}
