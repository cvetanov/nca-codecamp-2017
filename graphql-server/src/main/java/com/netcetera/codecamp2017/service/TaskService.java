package com.netcetera.codecamp2017.service;

import com.netcetera.codecamp2017.enumeration.TaskStatus;
import com.netcetera.codecamp2017.type.Task;

import java.util.Date;
import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task getById(Long id);

    Task save(Task task);

    void deleteById(String id);

    List<Task> getAllByStatus(TaskStatus taskStatus);

    List<Task> getAllByDateScheduled(Date date);
}
