package com.netcetera.codecamp.graphqldemo.repository;

import com.netcetera.codecamp.graphqldemo.domain.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> { }
