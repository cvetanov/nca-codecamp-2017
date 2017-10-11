package com.netcetera.codecamp2017.repository;

import com.netcetera.codecamp2017.domain.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> { }
