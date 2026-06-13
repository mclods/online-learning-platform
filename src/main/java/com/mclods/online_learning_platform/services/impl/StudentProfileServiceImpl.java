package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Student;
import com.mclods.online_learning_platform.entities.StudentProfile;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.StudentProfileRepository;
import com.mclods.online_learning_platform.services.StudentProfileService;
import com.mclods.online_learning_platform.services.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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
        Integer studentId = studentProfile.getStudent().getId();
        Optional<Student> savedStudent = studentService.findStudentById(studentId);

        if(savedStudent.isEmpty() || !savedStudent.get().equals(studentProfile.getStudent())) {
            throw new EntityDoesNotExistException(studentProfile.getStudent());
        }

        studentProfile.setId(null);

        StudentProfile savedStudentProfile = studentProfileRepository.save(studentProfile);
        log.info("StudentProfile created with id={}", savedStudentProfile.getId());

        return savedStudentProfile;
    }

    @Override
    public List<StudentProfile> createStudentProfiles(List<StudentProfile> studentProfiles) throws EntityDoesNotExistException {
        List<StudentProfile> savedStudentProfiles = new ArrayList<>();

        for(StudentProfile studentProfile : studentProfiles) {
            savedStudentProfiles.add(createStudentProfile(studentProfile));
        }
        return savedStudentProfiles;
    }

    @Override
    public void deleteAllStudentProfiles() {
        studentProfileRepository.deleteAll();
        log.info("All student profiles deleted");
    }
}
