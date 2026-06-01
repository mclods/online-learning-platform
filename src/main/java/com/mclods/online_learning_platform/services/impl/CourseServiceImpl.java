package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Course;
import com.mclods.online_learning_platform.entities.Instructor;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.CourseRepository;
import com.mclods.online_learning_platform.services.CourseService;
import com.mclods.online_learning_platform.services.InstructorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        if(!instructorService.instructorExistsById(course.getInstructor().getId())) {
            throw new EntityDoesNotExistException(Instructor.class, course.getInstructor().getId());
        }

        course.setId(null);

        if(course.getCreatedAt() == null) {
            course.setCreatedAt(LocalDateTime.now());
        }

        return courseRepository.save(course);
    }

    @Override
    public boolean courseExistsById(Integer id) {
        return courseRepository.existsById(id);
    }
}
