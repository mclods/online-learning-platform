package com.mclods.online_learning_platform.repositories.impl;

import com.mclods.online_learning_platform.entities.Submission;
import com.mclods.online_learning_platform.repositories.SubmissionCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubmissionCriteriaRepositoryImpl implements SubmissionCriteriaRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public SubmissionCriteriaRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Submission> findByScoreBetween(Double minScore, Double maxScore) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Submission> cq = cb.createQuery(Submission.class);

        Root<Submission> root = cq.from(Submission.class);

        List<Predicate> predicates = new ArrayList<>();
        if(minScore != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("score"), minScore));
        }

        if(maxScore != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("score"), maxScore));
        }

        cq.select(root).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
