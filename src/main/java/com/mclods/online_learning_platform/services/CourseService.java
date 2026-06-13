package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Course;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course createCourse(Course course) throws EntityDoesNotExistException;

    List<Course> createCourses(List<Course> courses) throws EntityDoesNotExistException;

    List<Course> findAllCourses();

    Optional<Course> findCourseById(Integer id);

    Course fullUpdateCourse(Course course) throws EntityDoesNotExistException;

    List<Course> fullUpdateCourses(List<Course> courses) throws EntityDoesNotExistException;

    List<Course> findCoursesHavingTitleContainingWordIgnoreCase(String word);

    List<Course> findCoursesHavingPriceBetween(Double minPrice, Double maxPrice);

    List<Course> findCoursesHavingPriceBetweenSortedByTitle(Double minPrice, Double maxPrice);

    Long findNumberOfIntermediateCourses();

    List<Course> findCoursesHavingInstructorId(Integer id);

    List<Course> findCoursesByStudentId(Integer id);

    void deleteAllCourses();
}
