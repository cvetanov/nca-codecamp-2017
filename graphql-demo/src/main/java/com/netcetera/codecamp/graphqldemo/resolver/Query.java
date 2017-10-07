package com.netcetera.codecamp.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.netcetera.codecamp.graphqldemo.service.ProjectService;
import com.netcetera.codecamp.graphqldemo.service.TaskService;
import com.netcetera.codecamp.graphqldemo.type.Project;
import com.netcetera.codecamp.graphqldemo.type.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private TaskService taskService;
    private ProjectService projectService;

    @Autowired
    public Query(TaskService taskService,ProjectService projectService)
    {
        this.taskService = taskService;
        this.projectService= projectService;
    }

    public List<Task> tasks() {
        return taskService.getAll();
    }

    public List<Project> projects() {
        return projectService.getAll();
    }

    public Project project(Long id) { return projectService.getById(id); }
}
