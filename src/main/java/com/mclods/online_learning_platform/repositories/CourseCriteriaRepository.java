package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Course;

import java.util.List;

public interface CourseCriteriaRepository {
    List<Course> findCoursesByStudentId(Integer id);
}
