package com.netcetera.codecamp2017.type;

import java.util.ArrayList;
import java.util.List;

public class Project extends BaseType {

    private String name;
    private String description;
    private List<Task> tasks=new ArrayList<>();

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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
