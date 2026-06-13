package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor createInstructor(Instructor instructor);

    List<Instructor> createInstructors(List<Instructor> instructors);

    List<Instructor> findAllInstructors();

    boolean instructorExistsById(Integer id);

    void deleteAllInstructors();
}
