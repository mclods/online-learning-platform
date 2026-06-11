package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Submission;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

import java.util.List;

public interface SubmissionService {
    Submission createSubmission(Submission submission) throws EntityDoesNotExistException;

    List<Submission> createSubmissions(List<Submission> submissions) throws EntityDoesNotExistException;

    List<Submission> findSubmissionsHavingScoreBetween(Double minScore, Double maxScore);
}
