package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> createStudents(List<Student> students);

    List<Student> findAllStudents();

    Optional<Student> findStudentById(Integer id);
}
