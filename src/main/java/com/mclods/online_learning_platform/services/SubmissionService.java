package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Submission;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

public interface SubmissionService {
    Submission createSubmission(Submission submission) throws EntityDoesNotExistException;
}
