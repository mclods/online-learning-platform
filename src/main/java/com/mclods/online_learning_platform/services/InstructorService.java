package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Instructor;

public interface InstructorService {
    Instructor createInstructor(Instructor instructor);

    boolean instructorExistsById(Integer id);
}
