package com.netcetera.codecamp.graphqldemo.repository;

import com.netcetera.codecamp.graphqldemo.domain.TaskEntity;
import com.netcetera.codecamp.graphqldemo.enumeration.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByTaskStatus(TaskStatus taskStatus);
}
