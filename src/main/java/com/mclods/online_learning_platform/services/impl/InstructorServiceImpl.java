package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Instructor;
import com.mclods.online_learning_platform.repositories.InstructorRepository;
import com.mclods.online_learning_platform.services.InstructorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Instructor createInstructor(@Valid Instructor instructor) {
        instructor.setId(null);

        return instructorRepository.save(instructor);
    }

    @Override
    public boolean instructorExistsById(Integer id) {
        return instructorRepository.existsById(id);
    }
}
