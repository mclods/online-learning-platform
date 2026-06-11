package com.mclods.online_learning_platform.configuration;

import com.mclods.online_learning_platform.entities.*;
import com.mclods.online_learning_platform.entities.Module;
import com.mclods.online_learning_platform.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class AppConfig {
    @Bean
    public CommandLineRunner commandLineRunner(StudentService studentService, CourseService courseService, ModuleService moduleService, AssignmentService assignmentService, SubmissionService submissionService) {
        return args -> {
            System.out.println("Queries");
            System.out.println("Find students having email nikhil.joshi@mail.com");
            studentService.findStudentsByEmail("nikhil.joshi@mail.com")
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


            System.out.println("Find number of intermediate courses");
            System.out.println(courseService.findNumberOfIntermediateCourses());
            System.out.println();


            System.out.println("Find courses containing the word spring in their title");
            courseService.findCoursesHavingTitleContainingWordIgnoreCase("spring")
                    .stream()
                    .map(Course::getTitle)
                    .forEach(System.out::println);
            System.out.println();


            System.out.println("Find students who have completed at least one course");
            studentService.findStudentNamesCompletedAtLeastOneCourse()
                    .forEach(System.out::println);
            System.out.println();


            System.out.println("Find all module names belonging to given course id");
            moduleService.findModulesByCourseId(52)
                    .stream()
                    .map(Module::getTitle)
                    .forEach(System.out::println);
            System.out.println();


            System.out.println("Find assignments having due date before today");
            assignmentService.findAssignmentsByDueDateLessThan(LocalDate.now().atStartOfDay())
                    .stream()
                    .map(Assignment::getTitle)
                    .forEach(System.out::println);
            System.out.println();


            System.out.println("Find students whose name contain the word an");
            studentService.findStudentsHavingNameContainingWord("an")
                    .stream()
                    .map(Student::getName)
                    .forEach(System.out::println);
            System.out.println();


            System.out.println("Find courses having taught by instructor with id 58");
            courseService.findCoursesHavingInstructorId(58)
                    .stream()
                    .map(Course::getTitle)
                    .forEach(System.out::println);
            System.out.println();


            System.out.println("Find submissions with a score between 70 and 80");
            submissionService.findSubmissionsHavingScoreBetween(70.0, 80.0)
                    .stream()
                    .map(Submission::getId)
                    .forEach(System.out::println);
            System.out.println();


            System.out.println("Find all courses in which student with id 448 enrolled");
            courseService.findCoursesByStudentId(448)
                    .stream()
                    .map(Course::getTitle)
                    .forEach(System.out::println);
            System.out.println();
        };
    }
}
