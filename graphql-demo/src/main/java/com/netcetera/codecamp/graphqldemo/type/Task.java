package com.netcetera.codecamp.graphqldemo.type;

import com.netcetera.codecamp.graphqldemo.enumeration.Priority;
import com.netcetera.codecamp.graphqldemo.enumeration.TaskStatus;

public class Task extends BaseType {
    public static final String DEFAULT_DATE = "12-30-2100";

    private String name;
    private String description;
    private String dateScheduled = Task.DEFAULT_DATE;

    private Priority priority = Priority.PRIORITY_DEFAULT;

    // TODO gcvetano 2017-10-08: change to only `status`
    // do the same in the components which are using this model
    private TaskStatus taskStatus = TaskStatus.CREATED;

    private Project project;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDateScheduled() {
        return dateScheduled;
    }

    public void setDateScheduled(String dateScheduled) {
        if (dateScheduled == null) {
            this.dateScheduled = Task.DEFAULT_DATE;
        } else {
            this.dateScheduled = dateScheduled;
        }
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
