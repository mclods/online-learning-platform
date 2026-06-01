package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Module;
import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository extends CrudRepository<Module, Integer> {
}
