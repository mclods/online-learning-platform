package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Assignment;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

public interface AssignmentService {
    Assignment createAssignment(Assignment assignment) throws EntityDoesNotExistException;

    boolean assignmentExistsById(Integer id);
}
