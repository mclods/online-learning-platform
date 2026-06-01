package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    boolean studentExistsById(Integer id);

    List<Student> findAllStudents();
}
