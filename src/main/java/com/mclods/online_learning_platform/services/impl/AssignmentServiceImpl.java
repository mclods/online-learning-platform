package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Assignment;
import com.mclods.online_learning_platform.entities.Module;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.AssignmentRepository;
import com.mclods.online_learning_platform.services.AssignmentService;
import com.mclods.online_learning_platform.services.ModuleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

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
            throw new EntityDoesNotExistException(Module.class, assignment.getModule().getId());
        }

        assignment.setId(null);

        return assignmentRepository.save(assignment);
    }

    @Override
    public boolean assignmentExistsById(Integer id) {
        return assignmentRepository.existsById(id);
    }
}
