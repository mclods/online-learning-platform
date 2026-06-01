package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Course;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

public interface CourseService {
    Course createCourse(Course course) throws EntityDoesNotExistException;

    boolean courseExistsById(Integer id);
}
