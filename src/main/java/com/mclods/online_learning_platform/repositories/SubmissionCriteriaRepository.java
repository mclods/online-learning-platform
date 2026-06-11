package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Submission;

import java.util.List;

public interface SubmissionCriteriaRepository {
    List<Submission> findByScoreBetween(Double minScore, Double maxScore);
}
