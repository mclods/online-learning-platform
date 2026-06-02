package com.mclods.online_learning_platform.repositories;

import com.mclods.online_learning_platform.entities.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Course> findByPriceBetweenOrderByTitle(Double minPrice, Double maxPrice);
}
