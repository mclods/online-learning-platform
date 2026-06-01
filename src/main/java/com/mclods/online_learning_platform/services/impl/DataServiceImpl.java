package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Student;
import com.mclods.online_learning_platform.entities.StudentProfile;
import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.services.DataService;
import com.mclods.online_learning_platform.services.StudentProfileService;
import com.mclods.online_learning_platform.services.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    private final StudentService studentService;
    private final StudentProfileService studentProfileService;

    public DataServiceImpl(StudentService studentService, StudentProfileService studentProfileService) {
        this.studentService = studentService;
        this.studentProfileService = studentProfileService;
    }

    @Override
    public void createDummyData() throws EntityDoesNotExistException {
        create10DummyStudents();
        create10DummyStudentProfiles();
    }

    private void create10DummyStudents() {
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
                        "Ananya Singh",
                        "ananya.singh@mail.com",
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

        students.forEach(studentService::createStudent);
    }

    private void create10DummyStudentProfiles() throws EntityDoesNotExistException {
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
        for(StudentProfile studentProfile : studentProfiles) {
            studentProfileService.createStudentProfile(studentProfile);
        }
    }
}
