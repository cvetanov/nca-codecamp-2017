package com.netcetera.codecamp.graphqldemo.service;

import com.netcetera.codecamp.graphqldemo.type.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();

    Project getById();

    Project save(Project task);

    void deleteById(String id);
}
