package com.mclods.online_learning_platform.configuration;

import com.mclods.online_learning_platform.entities.Course;
import com.mclods.online_learning_platform.entities.Student;
import com.mclods.online_learning_platform.services.CourseService;
import com.mclods.online_learning_platform.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CommandLineRunner commandLineRunner(StudentService studentService, CourseService courseService) {
        return args -> {
            System.out.println("Queries");
            System.out.println("Find students with name Aarav Patel");
            studentService
                    .findStudentsByName("Aarav Patel")
                    .stream()
                    .map(Student::getName)
                    .forEach(System.out::println);
            System.out.println();


            System.out.println("Find courses with price between 1500 & 3000");
            courseService.findCoursesHavingPriceBetween(1500.0, 3000.0)
                    .stream()
                    .map(Course::getTitle)
                    .forEach(System.out::println);
            System.out.println();


            System.out.println("Find courses with price between 1500 & 3000, sort them by title");
            courseService.findCoursesHavingPriceBetweenSortedByTitle(1500.0, 3000.0)
                    .stream()
                    .map(Course::getTitle)
                    .forEach(System.out::println);
            System.out.println();
        };
    }
}
