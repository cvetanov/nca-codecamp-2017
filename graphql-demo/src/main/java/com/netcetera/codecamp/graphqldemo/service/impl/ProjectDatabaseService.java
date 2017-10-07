package com.netcetera.codecamp.graphqldemo.service.impl;

import com.netcetera.codecamp.graphqldemo.domain.ProjectEntity;
import com.netcetera.codecamp.graphqldemo.mapper.ProjectMapper;
import com.netcetera.codecamp.graphqldemo.repository.ProjectRepository;
import com.netcetera.codecamp.graphqldemo.service.ProjectService;
import com.netcetera.codecamp.graphqldemo.type.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDatabaseService implements ProjectService{


    private ProjectMapper projectMapper;
    private ProjectRepository projectRepository;

    @Autowired
    ProjectDatabaseService(ProjectMapper projectMapper, ProjectRepository projectRepository){
        this.projectMapper=projectMapper;
        this.projectRepository=projectRepository;
    }

    @Override
    public List<Project> getAll() {
        final List<ProjectEntity> allProjects= projectRepository.findAll();
        return projectMapper.mapFromEntities(allProjects);
    }

    @Override
    public Project getById(Long id) {
        return projectMapper.mapFromEntity(projectRepository.findOne(id));
    }

    @Override
    public Project save(Project project)
    {
        final ProjectEntity projectEntity= projectMapper.mapToEntity(project);
        final ProjectEntity savedProjectEntity= projectRepository.save(projectEntity);
        return projectMapper.mapFromEntity(savedProjectEntity);
    }

    @Override
    public void deleteById(String id) {

    }
}
