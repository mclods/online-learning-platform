package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Assignment;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.AssignmentRepository;
import com.mclods.online_learning_platform.services.AssignmentService;
import com.mclods.online_learning_platform.services.ModuleService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AssignmentServiceImpl implements AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final ModuleService moduleService;

    public AssignmentServiceImpl(AssignmentRepository assignmentRepository, ModuleService moduleService) {
        this.assignmentRepository = assignmentRepository;
        this.moduleService = moduleService;
    }

    @Override
    public Assignment createAssignment(@Valid Assignment assignment) throws EntityDoesNotExistException {
        if(!moduleService.moduleExistsById(assignment.getModule().getId())) {
            throw new EntityDoesNotExistException(assignment.getModule());
        }

        assignment.setId(null);

        Assignment savedAssignment = assignmentRepository.save(assignment);
        log.info("Assignment created with id={}", savedAssignment.getId());

        return savedAssignment;
    }

    @Override
    public List<Assignment> createAssignments(List<Assignment> assignments) throws EntityDoesNotExistException {
        List<Assignment> savedAssignments = new ArrayList<>();

        for (Assignment assignment : assignments) {
            savedAssignments.add(createAssignment(assignment));
        }
        return savedAssignments;
    }

    @Override
    public List<Assignment> findAllAssignments() {
        List<Assignment> assignments = new ArrayList<>();
        assignmentRepository.findAll().forEach(assignments::add);

        return assignments;
    }

    @Override
    public boolean assignmentExistsById(Integer id) {
        return assignmentRepository.existsById(id);
    }

    @Override
    public void deleteAllAssignments() {
        assignmentRepository.deleteAll();
        log.info("All assignments deleted");
    }

    @Override
    public List<Assignment> findAssignmentsByDueDateLessThan(LocalDateTime dueDateLimit) {
        return assignmentRepository.findByDueDateLessThan(dueDateLimit);
    }
}
