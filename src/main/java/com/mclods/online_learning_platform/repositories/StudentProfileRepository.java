package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.StudentProfile;
import org.springframework.data.repository.CrudRepository;

public interface StudentProfileRepository extends CrudRepository<StudentProfile, Integer> {
}
