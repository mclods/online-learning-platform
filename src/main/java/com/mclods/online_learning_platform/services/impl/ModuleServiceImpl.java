package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Course;
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
import java.util.Optional;

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
        Integer courseId = module.getCourse().getId();
        Optional<Course> savedCourse = courseService.findCourseById(courseId);

        if(savedCourse.isEmpty() || !savedCourse.get().equals(module.getCourse())) {
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
    public Optional<Module> findModuleById(Integer id) {
        return moduleRepository.findById(id);
    }

    @Override
    public List<Module> findModulesByCourseId(Integer courseId) {
        return moduleRepository.findByCourseId(courseId);
    }

    @Override
    public void deleteAllModules() {
        moduleRepository.deleteAll();
        log.info("All modules deleted");
    }
}
