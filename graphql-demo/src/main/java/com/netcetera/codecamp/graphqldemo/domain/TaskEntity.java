package com.netcetera.codecamp.graphqldemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "TASK")
public class TaskEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String description;

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
}
