package com.netcetera.codecamp.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.netcetera.codecamp.graphqldemo.enumeration.TaskStatus;
import com.netcetera.codecamp.graphqldemo.service.ProjectService;
import com.netcetera.codecamp.graphqldemo.service.TaskService;
import com.netcetera.codecamp.graphqldemo.type.Project;
import com.netcetera.codecamp.graphqldemo.type.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
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

    public List<Task> linedUpTasks() {return taskService.getAllByStatus(TaskStatus.LINED_UP);}

    public Project project(Long id) { return projectService.getById(id); }

    public Task task(Long id) {
        return taskService.getById(id);
    }

    public List<Task> urgentTasks() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
       return taskService.getAllByDateScheduled(calendar.getTime());
    }
}
