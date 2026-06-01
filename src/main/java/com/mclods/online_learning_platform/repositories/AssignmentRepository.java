package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Assignment;
import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {
}
