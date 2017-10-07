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
    public Mutation(TaskService taskService,ProjectService projectService)
    {
        this.taskService = taskService;
        this.projectService=projectService;
    }



    public Task addTask(Task task) {
        return taskService.save(task);
    }

    public Project addTaskToProject(Task task, Long projectId){
        taskService.save(task);
        Project project = projectService.getById(projectId);
        project.getTasks().add(task);

        return projectService.save(project);
    }

    public Project addProject(Project project){
        return projectService.save(project);
    }
}
