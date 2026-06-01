package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Integer> {
}
