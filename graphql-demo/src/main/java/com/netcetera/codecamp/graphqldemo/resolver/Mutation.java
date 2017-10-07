package com.netcetera.codecamp.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.netcetera.codecamp.graphqldemo.service.ProjectService;
import com.netcetera.codecamp.graphqldemo.service.TaskService;
import com.netcetera.codecamp.graphqldemo.type.Project;
import com.netcetera.codecamp.graphqldemo.type.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private TaskService taskService;
    private ProjectService projectService;

    @Autowired
    public Mutation(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    // TODO gcvetano 2017-10-07: should we add separate POJOs for the Inputs?

    /**
     * Adds a new task in the persistence.
     * @param task the task to be added
     * @return the added task.
     */
    public Task addTask(Task task) {
        return taskService.save(task);
    }

    /**
     * Adds a new project in the persistence.
     * @param project the project to be added
     * @return the added project.
     */
    public Project addProject(Project project) {
        return projectService.save(project);
    }

    /**
     * Adds a task to a project.
     * @param task the task to be added.
     * @param projectId the id of the project to which the task belongs.
     * @return the project.
     */
    public Project addTaskToProject(Task task, Long projectId){
        taskService.save(task);
        Project project = projectService.getById(projectId);
        project.getTasks().add(task);
        return projectService.save(project);
    }
}
