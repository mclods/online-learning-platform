package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Student;
import com.mclods.online_learning_platform.repositories.StudentRepository;
import com.mclods.online_learning_platform.services.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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

        Student savedStudent = studentRepository.save(student);
        log.info("Student created with id {}", savedStudent.getId());

        return savedStudent;
    }

    @Override
    public List<Student> createStudents(List<Student> students) {
        return students.stream().map(this::createStudent).toList();
    }

    @Override
    public List<Student> findAllStudents() {
        return new ArrayList<>(studentRepository.findAll());
    }

    @Override
    public Optional<Student> findStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findStudentsByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<String> findStudentNamesCompletedAtLeastOneCourse() {
        return studentRepository.findStudentsCompletedAtLeastOneCourse();
    }

    @Override
    public List<Student> findStudentsHavingNameContainingWord(String word) {
        var student = new Student();
        student.setName(word);

        var matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(student,  matcher);
        return studentRepository.findAll(example);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
        log.info("All students deleted");
    }
}
