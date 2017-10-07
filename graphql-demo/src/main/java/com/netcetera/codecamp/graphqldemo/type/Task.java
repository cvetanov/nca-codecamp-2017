package com.netcetera.codecamp.graphqldemo.type;

import com.netcetera.codecamp.graphqldemo.enumeration.Priority;
import com.netcetera.codecamp.graphqldemo.enumeration.TaskStatus;

public class Task extends BaseType {

    private String name;
    private String description;

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
}
