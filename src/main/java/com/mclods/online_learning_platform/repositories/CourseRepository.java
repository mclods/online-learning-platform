package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer>, CourseCriteriaRepository {
    List<Course> findByTitleContainingIgnoreCase(String word);

    List<Course> findByPriceBetween(Double minPrice, Double maxPrice);

    @Query("SELECT c FROM Course c WHERE c.price BETWEEN :minPrice AND :maxPrice ORDER BY LOWER(c.title)")
    List<Course> findByPriceBetweenOrderByTitle(@Param("minPrice") Double minPrice, @Param("maxPrice")Double maxPrice);

    @Query(value = "SELECT COUNT(*) FROM course WHERE level = 'INTERMEDIATE'", nativeQuery = true)
    Long findNumberOfIntermediateCourses();

    List<Course> findByInstructorId(Integer id);
}
