package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Enrollment;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

import java.util.List;

public interface EnrollmentService {
    Enrollment createEnrollment(Enrollment enrollment) throws EntityDoesNotExistException;

    List<Enrollment> createEnrollments(List<Enrollment> enrollments) throws EntityDoesNotExistException;

    void deleteAllEnrollments();
}
