package com.netcetera.codecamp.graphqldemo.type;

import com.netcetera.codecamp.graphqldemo.enumeration.Priority;
import com.netcetera.codecamp.graphqldemo.enumeration.TaskStatus;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task extends BaseType {


    public static String defaultDate="12-30-2100";
    private String name;
    private String description;
    private String dateScheduled = Task.defaultDate;;


    private Priority priority=Priority.PRIORITY_DEFAULT;

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

    public String getDateScheduled() {
        return dateScheduled;
    }

    public void setDateScheduled(String dateScheduled) {
        if(dateScheduled==null){
            this.dateScheduled=Task.defaultDate;
        }
       else{
            this.dateScheduled = dateScheduled;
        }
    }
}
