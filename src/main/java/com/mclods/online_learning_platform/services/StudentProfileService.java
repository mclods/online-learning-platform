package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.StudentProfile;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

public interface StudentProfileService {
    StudentProfile createStudentProfile(StudentProfile studentProfile) throws EntityDoesNotExistException;
}
