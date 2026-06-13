package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.*;
import com.mclods.online_learning_platform.entities.Module;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.services.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataServiceImpl implements DataService {
    private final StudentService studentService;
    private final StudentProfileService studentProfileService;
    private final InstructorService instructorService;
    private final CourseService courseService;
    private final ModuleService moduleService;
    private final AssignmentService assignmentService;
    private final SubmissionService submissionService;
    private final EnrollmentService enrollmentService;
    private final TagService tagService;

    public DataServiceImpl(
            StudentService studentService,
            StudentProfileService studentProfileService,
            InstructorService instructorService,
            CourseService courseService,
            ModuleService moduleService,
            AssignmentService assignmentService,
            SubmissionService submissionService,
            EnrollmentService enrollmentService,
            TagService tagService) {
        this.studentService = studentService;
        this.studentProfileService = studentProfileService;
        this.instructorService = instructorService;
        this.courseService = courseService;
        this.moduleService = moduleService;
        this.assignmentService = assignmentService;
        this.submissionService = submissionService;
        this.enrollmentService = enrollmentService;
        this.tagService = tagService;
    }

    @Override
    public void createDummyData() throws EntityDoesNotExistException {
        createStudents();
        createStudentProfiles();
        createInstructors();
        createTags();
        createCourses();
        createModules();
        createAssignments();
        createSubmissions();
        createEnrollments();
    }

    @Override
    public void deleteDummyData() {
        studentService.deleteAllStudents();
        studentProfileService.deleteAllStudentProfiles();
        courseService.deleteAllCourses();
        instructorService.deleteAllInstructors();
        moduleService.deleteAllModules();
        assignmentService.deleteAllAssignments();
        submissionService.deleteAllSubmissions();
        enrollmentService.deleteAllEnrollments();
        tagService.deleteAllTags();
    }

    private void createStudents() {
        List<Student> students = List.of(
                new Student(
                        "Aarav Patel",
                        "aarav.patel@mail.com",
                        LocalDateTime.parse("2024-01-10T09:00:00")
                ),
                new Student(
                        "Divya Krishnan",
                        "divya.k@mail.com",
                        LocalDateTime.parse("2024-01-15T10:30:00")
                ),
                new Student(
                        "Rohan Gupta",
                        "rohan.gupta@mail.com",
                        LocalDateTime.parse("2024-02-01T08:45:00")
                ),
                new Student(
                        "Meera Iyer",
                        "meera.iyer@mail.com",
                        LocalDateTime.parse("2024-02-14T11:00:00")
                ),
                new Student(
                        "Karthik Reddy",
                        "karthik.r@mail.com",
                        LocalDateTime.parse("2024-03-05T14:20:00")
                ),
                new Student(
                        "Anya Singh",
                        "anya.singh@mail.com",
                        LocalDateTime.parse("2024-03-18T09:15:00")
                ),
                new Student(
                        "Nikhil Joshi",
                        "nikhil.joshi@mail.com",
                        LocalDateTime.parse("2024-04-02T16:00:00")
                ),
                new Student(
                        "Pooja Desai",
                        "pooja.desai@mail.com",
                        LocalDateTime.parse("2024-04-20T13:30:00")
                ),
                new Student(
                        "Siddharth Bose",
                        "siddharth.b@mail.com",
                        LocalDateTime.parse("2024-05-07T10:00:00")
                ),
                new Student(
                        "Lakshmi Menon",
                        "lakshmi.menon@mail.com",
                        LocalDateTime.parse("2024-05-22T12:45:00")
                )
        );
        studentService.createStudents(students);
    }

    private void createStudentProfiles() throws EntityDoesNotExistException {
        List<Student> students = studentService.findAllStudents();

        List<StudentProfile> studentProfiles = List.of(
                new StudentProfile(
                        "Aspiring backend developer learning Spring Boot.",
                        "https://i.pravatar.cc/150?u=1",
                        null,
                        students.get(0)
                ),
                new StudentProfile(
                        "Frontend enthusiast exploring full-stack development.",
                        "https://i.pravatar.cc/150?u=2",
                        LocalDate.parse("1999-07-25"),
                        students.get(1)
                ),
                new StudentProfile(
                        "DevOps learner interested in cloud and containers.",
                        "https://i.pravatar.cc/150?u=3",
                        LocalDate.parse("2001-01-08"),
                        students.get(2)
                ),
                new StudentProfile(
                        "Data science student with a love for SQL.",
                        "https://i.pravatar.cc/150?u=4",
                        LocalDate.parse("2000-11-30"),
                        students.get(3)
                ),
                new StudentProfile(
                        "Self-taught programmer focusing on Java.",
                        "https://i.pravatar.cc/150?u=5",
                        LocalDate.parse("1998-06-14"),
                        students.get(4)
                ),
                new StudentProfile(
                        "Computer science undergrad building side projects.",
                        "https://i.pravatar.cc/150?u=6",
                        null,
                        students.get(5)
                ),
                new StudentProfile(
                        "Preparing for software engineering interviews.",
                        "https://i.pravatar.cc/150?u=7",
                        LocalDate.parse("2001-04-03"),
                        students.get(6)
                ),
                new StudentProfile(
                        "Freelance developer upskilling in modern Java.",
                        "https://i.pravatar.cc/150?u=8",
                        LocalDate.parse("1997-12-22"),
                        students.get(7)
                ),
                new StudentProfile(
                        "Backend intern learning REST APIs and Spring.",
                        "https://i.pravatar.cc/150?u=9",
                        LocalDate.parse("2003-02-17"),
                        students.get(8)
                ),
                new StudentProfile(
                        "Graduate student bridging theory and practice.",
                        "https://i.pravatar.cc/150?u=10",
                        LocalDate.parse("1999-08-05"),
                        students.get(9)
                )
        );
        studentProfileService.createStudentProfiles(studentProfiles);
    }

    private void createInstructors() {
        List<Instructor> instructors = List.of(
                new Instructor("Arjun Mehta", "arjun.mehta@learnhub.io", "Backend engineer with 10 years of Java and Spring experience."),
                new Instructor("Priya Nair", "priya.nair@learnhub.io", "Full-stack developer and open-source contributor. Loves React and Node."),
                new Instructor("Vikram Sharma", "vikram.sharma@learnhub.io", null),
                new Instructor("Sneha Rao", "sneha.rao@learnhub.io", "DevOps practitioner with expertise in Docker, Kubernetes, and CI/CD.")
        );
        instructorService.createInstructors(instructors);
    }

    private void createTags() {
        List<Tag> tags = List.of(
                new Tag("Java"),
                new Tag("Spring Boot"),
                new Tag("Spring Security"),
                new Tag("JPA"),
                new Tag("SQL"),
                new Tag("REST API"),
                new Tag("DevOps"),
                new Tag("Docker"),
                new Tag("React"),
                new Tag("JavaScript"),
                new Tag("Databases"),
                new Tag("Testing")
        );
        tagService.createTags(tags);
    }

    private void createCourses() throws EntityDoesNotExistException {
        List<Instructor> instructors = instructorService.findAllInstructors();
        List<Tag> tags = tagService.findAllTags();

        List<Course> courses = List.of(
                new Course(
                        "Spring Boot from Scratch",
                        "Build production-ready REST APIs using Spring Boot and Spring Data JPA.",
                        1499.99,
                        Course.CourseLevel.BEGINNER,
                        LocalDateTime.parse("2024-01-05T10:00:00"),
                        instructors.get(0),
                        new HashSet<>(Set.of(tags.get(0), tags.get(1), tags.get(3),  tags.get(5)))
                ),
                new Course(
                        "Spring Security Masterclass",
                        "Secure your Spring applications with JWT, OAuth2, and method-level security.",
                        2499.00,
                        Course.CourseLevel.INTERMEDIATE,
                        LocalDateTime.parse("2024-02-01T10:00:00"),
                        instructors.get(0),
                        new HashSet<>(Set.of(tags.get(0), tags.get(1), tags.get(2)))
                ),
                new Course(
                        "Full-Stack with React and Spring",
                        "Connect a React frontend to a Spring Boot backend with REST and CORS.",
                        2999.00,
                        Course.CourseLevel.INTERMEDIATE,
                        null,
                        instructors.get(1),
                        new HashSet<>(Set.of(tags.get(0), tags.get(1), tags.get(5), tags.get(8), tags.get(9)))
                ),
                new Course(
                        "SQL and JPA Deep Dive",
                        "Master SQL, JPQL, Criteria API, and Specifications from the ground up.",
                        1999.00,
                        Course.CourseLevel.INTERMEDIATE,
                        LocalDateTime.parse("2024-03-01T10:00:00"),
                        instructors.get(2),
                        new HashSet<>(Set.of(tags.get(0), tags.get(3), tags.get(4), tags.get(10)))
                ),
                new Course(
                        "Docker and Kubernetes for Developers",
                        "Containerise your Spring applications and deploy them on Kubernetes.",
                        3499.00,
                        Course.CourseLevel.ADVANCED,
                        LocalDateTime.parse("2024-03-20T10:00:00"),
                        instructors.get(3),
                        new HashSet<>(Set.of(tags.get(6), tags.get(7)))
                ),
                new Course(
                        "Java Testing with JUnit and Mockito",
                        "Write unit tests, integration tests, and mocks for Spring Boot applications.",
                        999.00,
                        Course.CourseLevel.BEGINNER,
                        LocalDateTime.parse("2024-04-10T10:00:00"),
                        instructors.get(0),
                        new HashSet<>(Set.of(tags.get(0), tags.get(1), tags.get(11)))
                )
        );
        courseService.createCourses(courses);
    }

    private void createModules() throws EntityDoesNotExistException {
        List<Course> courses = courseService.findAllCourses();

        List<Module> modules = List.of(
                new Module("Introduction to Spring Boot", 1, courses.get(0)),
                new Module("Building REST Endpoints", 2, courses.get(0)),
                new Module("Spring Data JPA Basics", 3, courses.get(0)),
                new Module("Authentication with Spring Security", 1, courses.get(1)),
                new Module("JWT Token Implementation", 2, courses.get(1)),
                new Module("Method-Level Security", 3, courses.get(1)),
                new Module("Setting Up React and Spring", 1, courses.get(2)),
                new Module("REST API Integration", 2, courses.get(2)),
                new Module("State Management and Forms", 3, courses.get(2)),
                new Module("SQL Fundamentals", 1, courses.get(3)),
                new Module("JPQL and Named Queries", 2, courses.get(3)),
                new Module("Criteria API and Specifications", 3, courses.get(3)),
                new Module("Docker Fundamentals", 1, courses.get(4)),
                new Module("Dockerising Spring Boot Apps", 2, courses.get(4)),
                new Module("Kubernetes Basics", 3, courses.get(4)),
                new Module("JUnit 5 Basics", 1, courses.get(5)),
                new Module("Mockito and Mocking", 2, courses.get(5)),
                new Module("Integration Testing in Spring", 3, courses.get(5))
        );
        moduleService.createModules(modules);
    }

    private void createAssignments() throws EntityDoesNotExistException {
        List<Module> modules = moduleService.findAllModules();

        List<Assignment> assignments = List.of(
                new  Assignment(
                        "Hello World REST API",
                        100.00,
                        LocalDate.parse("2024-02-15").atStartOfDay(),
                        modules.get(1)
                ),
                new  Assignment(
                        "JPA Entity Design",
                        100.00,
                        LocalDate.parse("2024-03-01").atStartOfDay(),
                        modules.get(2)
                ),
                new  Assignment(
                        "Secure a REST Endpoint",
                        100.00,
                        LocalDate.parse("2024-03-20").atStartOfDay(),
                        modules.get(3)
                ),
                new  Assignment(
                        "Implement JWT Login",
                        100.00,
                        LocalDate.parse("2024-04-05").atStartOfDay(),
                        modules.get(4)
                ),
                new  Assignment(
                        "Apply @PreAuthorize",
                        100.00,
                        LocalDate.parse("2024-04-20").atStartOfDay(),
                        modules.get(5)
                ),
                new  Assignment(
                        "React Component with API Call",
                        100.00,
                        LocalDate.parse("2024-04-01").atStartOfDay(),
                        modules.get(7)
                ),
                new  Assignment(
                        "SQL Aggregation Queries",
                        100.00,
                        LocalDate.parse("2024-03-25").atStartOfDay(),
                        modules.get(9)
                ),
                new  Assignment(
                        "Write JPQL Queries",
                        100.00,
                        LocalDate.parse("2024-04-10").atStartOfDay(),
                        modules.get(10)
                ),
                new  Assignment(
                        "Specifications Filter",
                        100.00,
                        LocalDate.parse("2024-05-01").atStartOfDay(),
                        modules.get(11)
                ),
                new  Assignment(
                        "Write a Dockerfile",
                        100.00,
                        LocalDate.parse("2024-05-05").atStartOfDay(),
                        modules.get(13)
                ),
                new  Assignment(
                        "Deploy to Minikube",
                        100.00,
                        LocalDate.parse("2024-06-01").atStartOfDay(),
                        modules.get(14)
                ),
                new  Assignment(
                        "Unit Test a Service Class",
                        100.00,
                        LocalDate.parse("2024-05-20").atStartOfDay(),
                        modules.get(15)
                ),
                new  Assignment(
                        "Mock a Repository",
                        100.00,
                        LocalDate.parse("2024-06-05").atStartOfDay(),
                        modules.get(16)
                )
        );
        assignmentService.createAssignments(assignments);
    }

    private void createSubmissions() throws EntityDoesNotExistException {
        List<Student> students = studentService.findAllStudents();
        List<Assignment> assignments = assignmentService.findAllAssignments();

        List<Submission> submissions = List.of(
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-02-14T18:00:00"),
                        assignments.get(0),
                        students.get(0)
                ),
                new Submission(
                        76.0,
                        LocalDateTime.parse("2024-03-01T20:00:00"),
                        assignments.get(1),
                        students.get(0)
                ),
                new Submission(
                        91.0,
                        LocalDateTime.parse("2024-02-16T09:30:00"),
                        assignments.get(0),
                        students.get(1)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-03-25T15:00:00"),
                        assignments.get(6),
                        students.get(3)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-04-09T11:00:00"),
                        assignments.get(7),
                        students.get(3)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-04-30T22:00:00"),
                        assignments.get(8),
                        students.get(3)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-03-22T17:00:00"),
                        assignments.get(2),
                        students.get(4)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-04-06T14:00:00"),
                        assignments.get(3),
                        students.get(4)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-04-01T10:00:00"),
                        assignments.get(5),
                        students.get(5)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-05-08T19:00:00"),
                        assignments.get(7),
                        students.get(6)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-06-10T23:00:00"),
                        assignments.get(10),
                        students.get(6)
                ),
                new Submission(
                        88.0,
                        null,
                        assignments.get(11),
                        students.get(5)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-06-06T20:00:00"),
                        assignments.get(12),
                        students.get(5)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-02-20T08:00:00"),
                        assignments.get(0),
                        students.get(7)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-04-20T17:30:00"),
                        assignments.get(2),
                        students.get(7)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-05-12T13:00:00"),
                        assignments.get(11),
                        students.get(8)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-04-08T21:00:00"),
                        assignments.get(7),
                        students.get(9)
                ),
                new Submission(
                        88.0,
                        LocalDateTime.parse("2024-05-03T18:00:00"),
                        assignments.get(8),
                        students.get(9)
                )
        );
        submissionService.createSubmissions(submissions);
    }

    private void createEnrollments() throws EntityDoesNotExistException {
        List<Student> students = studentService.findAllStudents();
        List<Course> courses = courseService.findAllCourses();

        List<Enrollment> enrollments = List.of(
                new Enrollment(
                        students.get(0),
                        courses.get(0),
                        LocalDateTime.parse("2024-01-20T09:00:00"),
                        Enrollment.EnrollmentStatus.COMPLETED
                ),
                new Enrollment(
                        students.get(0),
                        courses.get(1),
                        LocalDateTime.parse("2024-03-01T09:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(0),
                        courses.get(5),
                        LocalDateTime.parse("2024-04-15T09:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(1),
                        courses.get(0),
                        LocalDateTime.parse("2024-01-25T10:00:00"),
                        Enrollment.EnrollmentStatus.COMPLETED
                ),
                new Enrollment(
                        students.get(1),
                        courses.get(2),
                        LocalDateTime.parse("2024-03-10T10:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(2),
                        courses.get(4),
                        null,
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(3),
                        courses.get(3),
                        LocalDateTime.parse("2024-03-05T11:00:00"),
                        Enrollment.EnrollmentStatus.COMPLETED
                ),
                new Enrollment(
                        students.get(3),
                        courses.get(0),
                        LocalDateTime.parse("2024-01-30T11:00:00"),
                        Enrollment.EnrollmentStatus.COMPLETED
                ),
                new Enrollment(
                        students.get(4),
                        courses.get(0),
                        LocalDateTime.parse("2024-02-10T14:00:00"),
                        Enrollment.EnrollmentStatus.DROPPED
                ),
                new Enrollment(
                        students.get(4),
                        courses.get(1),
                        null,
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(5),
                        courses.get(2),
                        LocalDateTime.parse("2024-04-01T09:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(5),
                        courses.get(5),
                        LocalDateTime.parse("2024-05-01T09:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(6),
                        courses.get(3),
                        LocalDateTime.parse("2024-03-20T16:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(6),
                        courses.get(4),
                        LocalDateTime.parse("2024-04-10T16:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(7),
                        courses.get(0),
                        LocalDateTime.parse("2024-02-20T13:00:00"),
                        Enrollment.EnrollmentStatus.COMPLETED
                ),
                new Enrollment(
                        students.get(7),
                        courses.get(1),
                        LocalDateTime.parse("2024-04-01T13:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(8),
                        courses.get(5),
                        LocalDateTime.parse("2024-05-10T10:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(8),
                        courses.get(0),
                        LocalDateTime.parse("2024-02-28T10:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(9),
                        courses.get(3),
                        LocalDateTime.parse("2024-04-05T12:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                ),
                new Enrollment(
                        students.get(9),
                        courses.get(2),
                        LocalDateTime.parse("2024-05-01T12:00:00"),
                        Enrollment.EnrollmentStatus.ACTIVE
                )
        );
        enrollmentService.createEnrollments(enrollments);
    }
}
