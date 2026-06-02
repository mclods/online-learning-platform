package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Instructor;
import com.mclods.online_learning_platform.repositories.InstructorRepository;
import com.mclods.online_learning_platform.services.InstructorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<Instructor> createInstructors(@Valid List<Instructor> instructors) {
        return instructors.stream().map(this::createInstructor).toList();
    }

    @Override
    public List<Instructor> findAllInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        instructorRepository.findAll().forEach(instructors::add);

        return instructors;
    }

    @Override
    public Optional<Instructor> findInstructorById(Integer id) {
        return instructorRepository.findById(id);
    }
}
