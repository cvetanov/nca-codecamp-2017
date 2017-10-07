package com.netcetera.codecamp.graphqldemo.mapper;

import com.netcetera.codecamp.graphqldemo.domain.ProjectEntity;
import com.netcetera.codecamp.graphqldemo.domain.TaskEntity;
import com.netcetera.codecamp.graphqldemo.type.Project;
import com.netcetera.codecamp.graphqldemo.type.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {

    private TaskMapper taskMapper;

    @Autowired
    public ProjectMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<ProjectEntity> mapToEntities(List<Project> projects){

        return projects
                .stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

    public ProjectEntity mapToEntity(Project project) {

        final ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(project.getId());
        projectEntity.setName(project.getName());
        projectEntity.setDescription(project.getDescription());

        final List<TaskEntity> taskEntities = taskMapper.mapToEntities(project.getTasks());
        taskEntities.forEach(t -> t.setProject(projectEntity));
        projectEntity.setTasks(taskEntities);

        return projectEntity;
    }

    public List<Project> mapFromEntities(List<ProjectEntity> projectEntities){
        return projectEntities
                .stream()
                .map(this::mapFromEntity)
                .collect(Collectors.toList());

    }

    public Project mapFromEntity(ProjectEntity projectEntity) {

        final Project project = new Project();
        project.setId(projectEntity.getId());
        project.setName(projectEntity.getName());
        project.setDescription(projectEntity.getDescription());

        final List<Task> tasks = taskMapper.mapFromEntities(projectEntity.getTasks());
        project.setTasks(tasks);
        return project;

    }
}
