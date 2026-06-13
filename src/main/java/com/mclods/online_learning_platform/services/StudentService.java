package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> createStudents(List<Student> students);

    List<Student> findAllStudents();

    boolean studentExistsById(Integer id);

    void deleteAllStudents();

    List<Student> findStudentsByEmail(String email);

    List<String> findStudentNamesCompletedAtLeastOneCourse();

    List<Student> findStudentsHavingNameContainingWord(String word);
}
