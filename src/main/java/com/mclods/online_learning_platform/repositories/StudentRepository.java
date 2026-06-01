package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
