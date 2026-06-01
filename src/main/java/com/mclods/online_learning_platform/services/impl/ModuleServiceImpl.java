package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Course;
import com.mclods.online_learning_platform.entities.Module;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.ModuleRepository;
import com.mclods.online_learning_platform.services.CourseService;
import com.mclods.online_learning_platform.services.ModuleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    private final CourseService courseService;

    public ModuleServiceImpl(ModuleRepository moduleRepository, CourseService courseService) {
        this.moduleRepository = moduleRepository;
        this.courseService = courseService;
    }

    @Override
    public Module createModule(@Valid Module module) throws EntityDoesNotExistException {
        if(!courseService.courseExistsById(module.getCourse().getId())) {
            throw new EntityDoesNotExistException(Course.class, module.getCourse().getId());
        }

        module.setId(null);

        return moduleRepository.save(module);
    }

    @Override
    public boolean moduleExistsById(Integer id) {
        return moduleRepository.existsById(id);
    }
}
