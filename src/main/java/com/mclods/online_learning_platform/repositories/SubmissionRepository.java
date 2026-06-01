package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Submission;
import org.springframework.data.repository.CrudRepository;

public interface SubmissionRepository extends CrudRepository<Submission, Integer> {
}
