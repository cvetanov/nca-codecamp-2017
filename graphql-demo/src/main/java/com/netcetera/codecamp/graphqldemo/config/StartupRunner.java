package com.netcetera.codecamp.graphqldemo.config;

import com.netcetera.codecamp.graphqldemo.domain.ProjectEntity;
import com.netcetera.codecamp.graphqldemo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void run(String... strings) throws Exception {
        ProjectEntity projectEntity= new ProjectEntity();
        projectEntity.setName("Default Project");
        projectEntity.setDescription("The tasks that do not have a defined project or the project is not set yet");
        projectRepository.save(projectEntity);
    }
}
