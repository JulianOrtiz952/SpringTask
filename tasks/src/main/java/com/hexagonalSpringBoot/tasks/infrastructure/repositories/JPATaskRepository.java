package com.hexagonalSpringBoot.tasks.infrastructure.repositories;

import com.hexagonalSpringBoot.tasks.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPATaskRepository extends JpaRepository<TaskEntity, Long> {
}
