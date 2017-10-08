package com.netcetera.codecamp2017.repository;

import com.netcetera.codecamp2017.domain.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Long>{


//        Project codeCamp = new Project();
//        codeCamp.setName("CodeCamp");
//        codeCamp.setId("1");
//        codeCamp.setDescription("Making a badass app for personal time management");
//        TaskRepository taskRepository = new TaskRepository();
//        codeCamp.setTasks(TaskRepository.get());
//        projects.add(codeCamp);
//

}
