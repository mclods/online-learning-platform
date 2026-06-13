package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Module;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.ModuleRepository;
import com.mclods.online_learning_platform.services.CourseService;
import com.mclods.online_learning_platform.services.ModuleService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
            throw new EntityDoesNotExistException(module.getCourse());
        }

        module.setId(null);

        Module savedModule = moduleRepository.save(module);
        log.info("Module created with id={}", savedModule.getId());

        return savedModule;
    }

    @Override
    public List<Module> createModules(List<Module> modules) throws EntityDoesNotExistException {
        List<Module> savedModules = new ArrayList<>();

        for (Module module : modules) {
            savedModules.add(createModule(module));
        }
        return savedModules;
    }

    @Override
    public List<Module> findAllModules() {
        List<Module> modules = new ArrayList<>();
        moduleRepository.findAll().forEach(modules::add);

        return modules;
    }

    @Override
    public boolean moduleExistsById(Integer id) {
        return moduleRepository.existsById(id);
    }

    @Override
    public void deleteAllModules() {
        moduleRepository.deleteAll();
        log.info("All modules deleted");
    }

    @Override
    public List<Module> findModulesByCourseId(Integer courseId) {
        return moduleRepository.findByCourseId(courseId);
    }
}
