package com.netcetera.codecamp2017.domain;

import com.netcetera.codecamp2017.enumeration.Priority;
import com.netcetera.codecamp2017.enumeration.TaskStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TASK")
public class TaskEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority=Priority.PRIORITY_DEFAULT;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus=TaskStatus.CREATED;

    @Column
    private Date dateScheduled;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

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

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
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

