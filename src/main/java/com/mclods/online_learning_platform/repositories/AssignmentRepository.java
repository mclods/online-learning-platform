package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Assignment;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {
    List<Assignment> findByDueDateLessThan(LocalDateTime dueDateLimit);
}
