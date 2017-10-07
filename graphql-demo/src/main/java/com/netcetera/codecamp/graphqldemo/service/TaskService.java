package com.netcetera.codecamp.graphqldemo.service;

import com.netcetera.codecamp.graphqldemo.type.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task getById();

    Task save(Task task);

    void deleteById(String id);
}
