package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Enrollment;
import com.mclods.online_learning_platform.entities.EnrollmentId;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.EnrollmentRepository;
import com.mclods.online_learning_platform.services.CourseService;
import com.mclods.online_learning_platform.services.EnrollmentService;
import com.mclods.online_learning_platform.services.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
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
            throw new EntityDoesNotExistException(enrollment.getStudent());
        }

        if(!courseService.courseExistsById(enrollment.getCourse().getId())) {
            throw new EntityDoesNotExistException(enrollment.getCourse());
        }

        enrollment.setId(new EnrollmentId());

        if(enrollment.getEnrolledAt() == null) {
            enrollment.setEnrolledAt(LocalDateTime.now());
        }

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        log.info("Enrollment created with id={}", savedEnrollment.getId());

        return savedEnrollment;
    }

    @Override
    public List<Enrollment> createEnrollments(List<Enrollment> enrollments) throws EntityDoesNotExistException {
        List<Enrollment> savedEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            savedEnrollments.add(createEnrollment(enrollment));
        }

        return savedEnrollments;
    }

    @Override
    public void deleteAllEnrollments() {
        enrollmentRepository.deleteAll();
        log.info("All enrollments deleted");
    }
}
