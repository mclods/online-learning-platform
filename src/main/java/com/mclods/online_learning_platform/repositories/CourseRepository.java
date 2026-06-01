package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
