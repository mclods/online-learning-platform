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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Integer studentId = enrollment.getStudent().getId(),
                courseId = enrollment.getCourse().getId();
        Optional<Student> savedStudent = studentService.findStudentById(studentId);
        Optional<Course> savedCourse = courseService.findCourseById(courseId);

        if(savedStudent.isEmpty() || !savedStudent.get().equals(enrollment.getStudent())) {
            throw new EntityDoesNotExistException(enrollment.getStudent());
        }

        if(savedCourse.isEmpty() || !savedCourse.get().equals(enrollment.getCourse())) {
            throw new EntityDoesNotExistException(enrollment.getCourse());
        }

        enrollment.setId(new EnrollmentId());

        if(enrollment.getEnrolledAt() == null) {
            enrollment.setEnrolledAt(LocalDateTime.now());
        }

        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> createEnrollments(List<Enrollment> enrollments) throws EntityDoesNotExistException {
        List<Enrollment> savedEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            savedEnrollments.add(createEnrollment(enrollment));
        }

        return savedEnrollments;
    }
}
