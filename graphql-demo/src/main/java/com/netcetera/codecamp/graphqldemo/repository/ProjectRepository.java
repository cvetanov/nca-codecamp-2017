package com.netcetera.codecamp.graphqldemo.repository;

import com.netcetera.codecamp.graphqldemo.domain.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,String>{


//        Project codeCamp = new Project();
//        codeCamp.setName("CodeCamp");
//        codeCamp.setId("1");
//        codeCamp.setDescription("Making a badass app for personal time management");
//        TaskRepository taskRepository = new TaskRepository();
//        codeCamp.setTasks(TaskRepository.get());
//        projects.add(codeCamp);
//

}
