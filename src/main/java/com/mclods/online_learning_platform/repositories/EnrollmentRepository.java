package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Enrollment;
import com.mclods.online_learning_platform.entities.EnrollmentId;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollment, EnrollmentId> {
}
