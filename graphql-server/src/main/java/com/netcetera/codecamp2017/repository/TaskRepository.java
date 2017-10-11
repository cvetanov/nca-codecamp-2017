package com.netcetera.codecamp2017.repository;

import com.netcetera.codecamp2017.domain.TaskEntity;
import com.netcetera.codecamp2017.enumeration.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByTaskStatus(TaskStatus taskStatus);

    List<TaskEntity> findAllByDateScheduled(Date date);
}
