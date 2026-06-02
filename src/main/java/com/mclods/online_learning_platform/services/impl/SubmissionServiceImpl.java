package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Assignment;
import com.mclods.online_learning_platform.entities.Student;
import com.mclods.online_learning_platform.entities.Submission;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.repositories.SubmissionRepository;
import com.mclods.online_learning_platform.services.AssignmentService;
import com.mclods.online_learning_platform.services.StudentService;
import com.mclods.online_learning_platform.services.SubmissionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    private final SubmissionRepository submissionRepository;
    private final AssignmentService assignmentService;
    private final StudentService studentService;

    public SubmissionServiceImpl(SubmissionRepository submissionRepository, AssignmentService assignmentService, StudentService studentService) {
        this.submissionRepository = submissionRepository;
        this.assignmentService = assignmentService;
        this.studentService = studentService;
    }

    @Override
    public Submission createSubmission(@Valid Submission submission) throws EntityDoesNotExistException {
        Integer assignmentId = submission.getAssignment().getId(),
                studentId = submission.getStudent().getId();
        Optional<Assignment> savedAssignment = assignmentService.findAssignmentById(assignmentId);
        Optional<Student> savedStudent = studentService.findStudentById(studentId);

        if(savedAssignment.isEmpty() || !savedAssignment.get().equals(submission.getAssignment())) {
            throw new EntityDoesNotExistException(submission.getAssignment());
        }

        if(savedStudent.isEmpty() || !savedStudent.get().equals(submission.getStudent())) {
            throw new EntityDoesNotExistException(submission.getStudent());
        }

        submission.setId(null);

        if(submission.getSubmittedAt() == null) {
            submission.setSubmittedAt(LocalDateTime.now());
        }

        return submissionRepository.save(submission);
    }

    @Override
    public List<Submission> createSubmissions(List<Submission> submissions) throws EntityDoesNotExistException {
        List<Submission> savedSubmissions = new ArrayList<>();
        for (Submission submission : submissions) {
            savedSubmissions.add(createSubmission(submission));
        }

        return savedSubmissions;
    }
}
