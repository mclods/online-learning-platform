package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Module;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

import java.util.List;

public interface ModuleService {
    Module createModule(Module module) throws EntityDoesNotExistException;

    List<Module> createModules(List<Module> modules) throws EntityDoesNotExistException;

    List<Module> findAllModules();

    boolean moduleExistsById(Integer id);

    void deleteAllModules();

    List<Module> findModulesByCourseId(Integer courseId);
}
