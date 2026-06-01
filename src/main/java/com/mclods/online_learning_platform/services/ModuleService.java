package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Module;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

public interface ModuleService {
    Module createModule(Module module) throws EntityDoesNotExistException;

    boolean moduleExistsById(Integer id);
}
