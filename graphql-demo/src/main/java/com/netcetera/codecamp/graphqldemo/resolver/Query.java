package com.netcetera.codecamp.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.netcetera.codecamp.graphqldemo.service.TaskService;
import com.netcetera.codecamp.graphqldemo.type.Project;
import com.netcetera.codecamp.graphqldemo.type.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private TaskService taskService;

    @Autowired
    public Query(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> tasks() {
        return taskService.getAll();
    }

    public List<Project> projects() {
        return new ArrayList<>();
    }
}
