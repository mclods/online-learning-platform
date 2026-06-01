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
        if(!assignmentService.assignmentExistsById(submission.getAssignment().getId())) {
            throw new EntityDoesNotExistException(Assignment.class, submission.getAssignment().getId());
        }

        if(!studentService.studentExistsById(submission.getStudent().getId())) {
            throw new EntityDoesNotExistException(Student.class, submission.getStudent().getId());
        }

        submission.setId(null);

        if(submission.getSubmittedAt() != null) {
            submission.setSubmittedAt(LocalDateTime.now());
        }

        return submissionRepository.save(submission);
    }
}
