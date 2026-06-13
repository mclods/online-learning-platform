package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Course;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course) throws EntityDoesNotExistException;

    List<Course> createCourses(List<Course> courses) throws EntityDoesNotExistException;

    List<Course> findAllCourses();

    boolean courseExistsById(Integer id);

    Course fullUpdateCourse(Course course) throws EntityDoesNotExistException;

    List<Course> fullUpdateCourses(List<Course> courses) throws EntityDoesNotExistException;

    void deleteAllCourses();

    List<Course> findCoursesHavingTitleContainingWordIgnoreCase(String word);

    List<Course> findCoursesHavingPriceBetween(Double minPrice, Double maxPrice);

    List<Course> findCoursesHavingPriceBetweenSortedByTitle(Double minPrice, Double maxPrice);

    Long findNumberOfIntermediateCourses();

    List<Course> findCoursesHavingInstructorId(Integer id);

    List<Course> findCoursesByStudentId(Integer id);
}
