package com.netcetera.codecamp.graphqldemo.type;

import com.netcetera.codecamp.graphqldemo.enumeration.Priority;
import com.netcetera.codecamp.graphqldemo.enumeration.TaskStatus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task extends BaseType {

    private String name;
    private String description;
    private String dateScheduled;

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
        if(dateScheduled==null){
            Calendar calendar= Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.HOUR_OF_DAY,0);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
            calendar.set(Calendar.MINUTE,0);
            SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
            dateScheduled=sdf.format(calendar.getTime());
        }
        return dateScheduled;

    }

    public void setDateScheduled(String dateScheduled) {
        this.dateScheduled = dateScheduled;
    }
}
