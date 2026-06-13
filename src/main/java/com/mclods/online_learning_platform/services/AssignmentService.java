package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Assignment;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

import java.time.LocalDateTime;
import java.util.List;

public interface AssignmentService {
    Assignment createAssignment(Assignment assignment) throws EntityDoesNotExistException;

    List<Assignment> createAssignments(List<Assignment> assignments) throws EntityDoesNotExistException;

    List<Assignment> findAllAssignments();

    boolean assignmentExistsById(Integer id);

    void deleteAllAssignments();

    List<Assignment> findAssignmentsByDueDateLessThan(LocalDateTime dueDateLimit);
}
