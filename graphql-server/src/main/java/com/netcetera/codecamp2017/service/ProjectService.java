package com.netcetera.codecamp2017.service;

import com.netcetera.codecamp2017.type.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();

    Project getById(Long id);

    Project save(Project task);

    void deleteById(String id);
}
