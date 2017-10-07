package com.netcetera.codecamp.graphqldemo.mapper;

import com.netcetera.codecamp.graphqldemo.domain.ProjectEntity;
import com.netcetera.codecamp.graphqldemo.type.Project;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {
    public List<ProjectEntity> mapToEntities(List<Project> projects){

        return projects
                .stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

    private ProjectEntity mapToEntity(Project project) {

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(project.getId());
        projectEntity.setName(project.getName());
        projectEntity.setDescription(project.getDescription());
        return projectEntity;
    }

    public List<Project> mapFromEntities(List<ProjectEntity> projectEntities){
        return projectEntities
                .stream()
                .map(this::mapFromEntity)
                .collect(Collectors.toList());

    }

    private Project mapFromEntity(ProjectEntity projectEntity) {
        Project project = new Project();
        project.setId(projectEntity.getId());
        project.setName(projectEntity.getName());
        project.setDescription(projectEntity.getDescription());
        return project;

    }
}
