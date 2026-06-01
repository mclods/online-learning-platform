package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Student;
import com.mclods.online_learning_platform.entities.StudentProfile;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.StudentProfileRepository;
import com.mclods.online_learning_platform.services.StudentProfileService;
import com.mclods.online_learning_platform.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {
    private final StudentProfileRepository studentProfileRepository;
    private final StudentService studentService;

    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository, StudentService studentService) {
        this.studentProfileRepository = studentProfileRepository;
        this.studentService = studentService;
    }

    @Override
    public StudentProfile createStudentProfile(@Valid StudentProfile studentProfile) throws EntityDoesNotExistException {
        if(!studentService.studentExistsById(studentProfile.getStudent().getId())) {
            throw new EntityDoesNotExistException(Student.class, studentProfile.getStudent().getId());
        }

        studentProfile.setId(null);

        return studentProfileRepository.save(studentProfile);
    }
}
