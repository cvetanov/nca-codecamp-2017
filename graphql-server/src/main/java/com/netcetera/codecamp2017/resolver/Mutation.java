package com.netcetera.codecamp2017.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.netcetera.codecamp2017.service.ProjectService;
import com.netcetera.codecamp2017.service.TaskService;
import com.netcetera.codecamp2017.type.Project;
import com.netcetera.codecamp2017.type.Task;
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
//        taskService.save(task);
        Project project = projectService.getById(projectId);
        project.getTasks().add(task);
        return projectService.save(project);
    }

    public Task updateTask(Task updatable){
        Task taskToUpdate = taskService.getById(updatable.getId());
        if(updatable.getName()!=null){
            taskToUpdate.setName(updatable.getName());
        }
        if(updatable.getDescription() != null){
            taskToUpdate.setDescription(updatable.getDescription());
        }
        if(updatable.getPriority() != null){
            taskToUpdate.setPriority(updatable.getPriority());
        }
        if(updatable.getTaskStatus() !=null){
            taskToUpdate.setTaskStatus(updatable.getTaskStatus());
        }

        return taskService.save(taskToUpdate);
    }

    public Project updateProject(Project updatable){
        Project projectToUpdate = projectService.getById(updatable.getId());
        if(updatable.getName()!= null){
            projectToUpdate.setName(updatable.getName());
        }
        if(updatable.getDescription()!=null){
            projectToUpdate.setDescription(updatable.getDescription());
        }

        return projectService.save(projectToUpdate);
    }
}
