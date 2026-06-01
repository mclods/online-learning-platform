package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Student;
import com.mclods.online_learning_platform.repositories.StudentRepository;
import com.mclods.online_learning_platform.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(@Valid Student student) {
        student.setId(null);

        if(student.getCreatedAt() == null) {
            student.setCreatedAt(LocalDateTime.now());
        }

        return studentRepository.save(student);
    }

    @Override
    public boolean studentExistsById(Integer id) {
        return studentRepository.existsById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);

        return students;
    }
}
