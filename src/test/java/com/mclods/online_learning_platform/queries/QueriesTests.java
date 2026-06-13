package com.mclods.online_learning_platform.queries;

import com.mclods.online_learning_platform.entities.*;
import com.mclods.online_learning_platform.entities.Module;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QueriesTests {
    private final StudentService studentService;
    private final CourseService courseService;
    private final ModuleService moduleService;
    private final AssignmentService assignmentService;
    private final SubmissionService submissionService;

    @Autowired
    public QueriesTests(StudentService studentService, CourseService courseService, ModuleService moduleService, AssignmentService assignmentService, SubmissionService submissionService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.moduleService = moduleService;
        this.assignmentService = assignmentService;
        this.submissionService = submissionService;
    }

    @BeforeAll
    public static void setup(@Autowired DataService dataService) throws EntityDoesNotExistException {
        dataService.deleteDummyData();
        dataService.createDummyData();
    }

    @Test
    @DisplayName("Find students having email nikhil.joshi@mail.com")
    void findStudentsHavingEmail() {
        var students = studentService.findStudentsByEmail("nikhil.joshi@mail.com")
                .stream()
                .map(Student::getName)
                .toList();

        assertThat(students).containsExactly("Nikhil Joshi");
    }

    @Test
    @DisplayName("Find courses with price between 1500 & 3000")
    void findCoursesHavingPriceBetween() {
        var courses = courseService.findCoursesHavingPriceBetween(1500.0, 3000.0)
                .stream()
                .map(Course::getTitle)
                .toList();

        assertThat(courses).containsExactlyInAnyOrder(
                "Spring Security Masterclass",
                "Full-Stack with React and Spring",
                "SQL and JPA Deep Dive"
        );
    }

    @Test
    @DisplayName("Find courses with price between 1500 & 3000, sort them by title")
    void findCoursesHavingPriceBetweenSortedByTitle() {
        var courses = courseService.findCoursesHavingPriceBetweenSortedByTitle(1500.0, 3000.0)
                .stream()
                .map(Course::getTitle)
                .toList();

        assertThat(courses).containsExactly(
                "Full-Stack with React and Spring",
                "Spring Security Masterclass",
                "SQL and JPA Deep Dive"
        );
    }

    @Test
    @DisplayName("Find number of intermediate courses")
    void findNumberOfIntermediateCourses() {
        var count = courseService.findNumberOfIntermediateCourses();

        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("Find courses containing the word spring in their title")
    void findCoursesContainingTheWordSpringInTheirTitle() {
        var courses = courseService.findCoursesHavingTitleContainingWordIgnoreCase("spring")
                .stream()
                .map(Course::getTitle)
                .toList();

        assertThat(courses).containsExactlyInAnyOrder(
                "Spring Boot from Scratch",
                "Spring Security Masterclass",
                "Full-Stack with React and Spring"
        );
    }

    @Test
    @DisplayName("Find students who have completed at least one course")
    void findStudentsWhoHaveCompletedAtLeastOneCourse() {
        var students = studentService.findStudentNamesCompletedAtLeastOneCourse();

        assertThat(students).containsExactlyInAnyOrder(
                "Pooja Desai",
                "Divya Krishnan",
                "Meera Iyer",
                "Aarav Patel"
        );
    }

    @Test
    @DisplayName("Find all module names belonging to given course id")
    void findAllModuleNamesBelongingToGivenCourseId() {
        var modules = moduleService.findModulesByCourseId(2)
                .stream()
                .map(Module::getTitle)
                .toList();

        assertThat(modules).containsExactlyInAnyOrder(
                "Authentication with Spring Security",
                "JWT Token Implementation",
                "Method-Level Security"
        );
    }

    @Test
    @DisplayName("Find assignments having due date before today")
    void findAssignmentsHavingDueDateBeforeToday() {
        var assignments = assignmentService.findAssignmentsByDueDateLessThan(LocalDate.now().atStartOfDay())
                .stream()
                .map(Assignment::getTitle)
                .toList();

        assertThat(assignments).containsExactlyInAnyOrder(
                "Hello World REST API",
                "JPA Entity Design",
                "Secure a REST Endpoint",
                "Implement JWT Login",
                "Apply @PreAuthorize",
                "React Component with API Call",
                "SQL Aggregation Queries",
                "Write JPQL Queries",
                "Specifications Filter",
                "Write a Dockerfile",
                "Deploy to Minikube",
                "Unit Test a Service Class",
                "Mock a Repository"
        );
    }

    @Test
    @DisplayName("Find students whose name contain the word an")
    void findStudentsWhoseNameContainTheWordAn() {
        var students = studentService.findStudentsHavingNameContainingWord("an")
                .stream()
                .map(Student::getName)
                .toList();

        assertThat(students).containsExactlyInAnyOrder(
                "Divya Krishnan",
                "Rohan Gupta",
                "Anya Singh"
        );
    }

    @Test
    @DisplayName("Find courses being taught by instructor with id 3")
    void findCoursesBeingTaughtByInstructorWithId3() {
        var courses = courseService.findCoursesHavingInstructorId(3)
                .stream()
                .map(Course::getTitle)
                .toList();

        assertThat(courses).containsExactlyInAnyOrder("SQL and JPA Deep Dive");
    }

    @Test
    @DisplayName("Find submissions with a score between 70 and 80")
    void findSubmissionsWithAScoreBetween70And80() {
        var submissions = submissionService.findSubmissionsHavingScoreBetween(70.0, 80.0)
                .stream()
                .map(Submission::getId)
                .toList();

        assertThat(submissions).containsExactlyInAnyOrder(2);
    }

    @Test
    @DisplayName("Find all courses in which student with id 2 enrolled")
    void findAllCoursesInWhichStudentWithId2Enrolled() {
        var courses = courseService.findCoursesByStudentId(2)
                .stream()
                .map(Course::getTitle)
                .toList();

        assertThat(courses).containsExactlyInAnyOrder(
                "Spring Boot from Scratch",
                "Full-Stack with React and Spring"
        );
    }
}
