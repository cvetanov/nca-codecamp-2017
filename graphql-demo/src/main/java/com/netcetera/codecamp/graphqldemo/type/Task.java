package com.netcetera.codecamp.graphqldemo.type;

import com.netcetera.codecamp.graphqldemo.enumeration.Priority;
import com.netcetera.codecamp.graphqldemo.enumeration.TaskStatus;

import java.util.Date;

public class Task extends BaseType {

    private String name;
    private String description;
    private Date dateScheduled;

    private Priority priority=Priority.PRIORITYDEFAULT;

    private TaskStatus taskStatus=TaskStatus.CREATED;

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

    public Date getDateScheduled() {
        return dateScheduled;
    }

    public void setDateScheduled(Date dateScheduled) {
        this.dateScheduled = dateScheduled;
    }
}
