package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    Instructor createInstructor(Instructor instructor);

    List<Instructor> createInstructors(List<Instructor> instructors);

    List<Instructor> findAllInstructors();

    Optional<Instructor> findInstructorById(Integer id);

    void deleteAllInstructors();
}
