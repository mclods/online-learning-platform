package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Module;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Integer> {
    List<Module> findByCourseId(Integer courseId);
}
