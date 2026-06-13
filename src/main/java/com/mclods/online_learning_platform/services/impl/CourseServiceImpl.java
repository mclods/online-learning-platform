package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Course;
import com.mclods.online_learning_platform.entities.Instructor;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.CourseRepository;
import com.mclods.online_learning_platform.services.CourseService;
import com.mclods.online_learning_platform.services.InstructorService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final InstructorService instructorService;

    public CourseServiceImpl(CourseRepository courseRepository, InstructorService instructorService) {
        this.courseRepository = courseRepository;
        this.instructorService = instructorService;
    }

    @Override
    public Course createCourse(@Valid Course course) throws EntityDoesNotExistException {
        Integer instructorId = course.getInstructor().getId();
        Optional<Instructor> savedInstructor = instructorService.findInstructorById(instructorId);

        if(savedInstructor.isEmpty() || !savedInstructor.get().equals(course.getInstructor())) {
            throw new EntityDoesNotExistException(course.getInstructor());
        }

        course.setId(null);

        if(course.getCreatedAt() == null) {
            course.setCreatedAt(LocalDateTime.now());
        }

        Course savedCourse = courseRepository.save(course);
        log.info("Course created with id={}", savedCourse.getId());

        return savedCourse;
    }

    @Override
    public List<Course> createCourses(List<Course> courses) throws EntityDoesNotExistException {
        List<Course> savedCourses = new ArrayList<>();

        for (Course course : courses) {
            savedCourses.add(createCourse(course));
        }
        return savedCourses;
    }

    @Override
    public List<Course> findAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);

        return courses;
    }

    @Override
    public Optional<Course> findCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course fullUpdateCourse(Course course) throws EntityDoesNotExistException {
        Integer instructorId = course.getInstructor().getId();
        Optional<Instructor> savedInstructor = instructorService.findInstructorById(instructorId);

        if(savedInstructor.isEmpty() || !savedInstructor.get().equals(course.getInstructor())) {
            throw new EntityDoesNotExistException(course.getInstructor());
        }

        return courseRepository.save(course);
    }

    @Override
    public List<Course> fullUpdateCourses(List<Course> courses) throws EntityDoesNotExistException {
        List<Course> updatedCourses = new ArrayList<>();
        for (Course course : courses) {
            updatedCourses.add(fullUpdateCourse(course));
        }

        return updatedCourses;
    }

    @Override
    public List<Course> findCoursesHavingTitleContainingWordIgnoreCase(String word) {
        return courseRepository.findByTitleContainingIgnoreCase(word);
    }

    @Override
    public List<Course> findCoursesHavingPriceBetween(Double minPrice, Double maxPrice) {
        return courseRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Course> findCoursesHavingPriceBetweenSortedByTitle(Double minPrice, Double maxPrice) {
        return courseRepository.findByPriceBetweenOrderByTitle(minPrice, maxPrice);
    }

    @Override
    public Long findNumberOfIntermediateCourses() {
        return courseRepository.findNumberOfIntermediateCourses();
    }

    @Override
    public List<Course> findCoursesHavingInstructorId(Integer id) {
        return courseRepository.findByInstructorId(id);
    }

    @Override
    public List<Course> findCoursesByStudentId(Integer id) {
        return courseRepository.findCoursesByStudentId(id);
    }

    @Override
    public void deleteAllCourses() {
        courseRepository.deleteAll();
        log.info("All courses deleted");
    }
}
