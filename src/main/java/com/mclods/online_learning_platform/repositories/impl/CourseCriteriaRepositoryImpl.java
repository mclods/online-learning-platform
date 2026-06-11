package com.mclods.online_learning_platform.repositories.impl;

import com.mclods.online_learning_platform.entities.Course;
import com.mclods.online_learning_platform.entities.Enrollment;
import com.mclods.online_learning_platform.entities.Student;
import com.mclods.online_learning_platform.repositories.CourseCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseCriteriaRepositoryImpl implements CourseCriteriaRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public CourseCriteriaRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findCoursesByStudentId(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> root = cq.from(Course.class);
        Join<Course, Enrollment> enrollmentJoin = root.join("enrollments");
        Join<Enrollment, Student> studentJoin = enrollmentJoin.join("student");

        List<Predicate> predicates = new ArrayList<>();

        if(id != null) {
            predicates.add(cb.equal(studentJoin.get("id"), id));
        }

        cq.select(root).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
