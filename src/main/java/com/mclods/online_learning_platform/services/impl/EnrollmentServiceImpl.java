package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Course;
import com.mclods.online_learning_platform.entities.Enrollment;
import com.mclods.online_learning_platform.entities.EnrollmentId;
import com.mclods.online_learning_platform.entities.Student;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.EnrollmentRepository;
import com.mclods.online_learning_platform.services.CourseService;
import com.mclods.online_learning_platform.services.EnrollmentService;
import com.mclods.online_learning_platform.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, StudentService studentService, CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public Enrollment createEnrollment(@Valid Enrollment enrollment) throws EntityDoesNotExistException {
        if(!studentService.studentExistsById(enrollment.getStudent().getId())) {
            throw new EntityDoesNotExistException(Student.class, enrollment.getStudent().getId());
        }

        if(!courseService.courseExistsById(enrollment.getCourse().getId())) {
            throw new EntityDoesNotExistException(Course.class, enrollment.getCourse().getId());
        }

        EnrollmentId enrollmentId = new EnrollmentId(
                enrollment.getStudent().getId(),
                enrollment.getCourse().getId()
        );
        enrollment.setId(enrollmentId);

        return enrollmentRepository.save(enrollment);
    }
}
