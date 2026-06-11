package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Assignment;
import com.mclods.online_learning_platform.entities.Module;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.AssignmentRepository;
import com.mclods.online_learning_platform.services.AssignmentService;
import com.mclods.online_learning_platform.services.ModuleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Integer moduleId = assignment.getModule().getId();
        Optional<Module> savedModule = moduleService.findModuleById(moduleId);

        if(savedModule.isEmpty() || !savedModule.get().equals(assignment.getModule())) {
            throw new EntityDoesNotExistException(assignment.getModule());
        }

        assignment.setId(null);

        return assignmentRepository.save(assignment);
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
    public Optional<Assignment> findAssignmentById(Integer id) {
        return assignmentRepository.findById(id);
    }

    @Override
    public List<Assignment> findAssignmentsByDueDateLessThan(LocalDateTime dueDateLimit) {
        return assignmentRepository.findByDueDateLessThan(dueDateLimit);
    }
}
