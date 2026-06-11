package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByEmail(String email);

    @Query("SELECT s.name FROM Student s JOIN Enrollment e ON s.id = e.id.studentId WHERE e.status = 'COMPLETED' GROUP BY s.name")
    List<String> findStudentsCompletedAtLeastOneCourse();
}
