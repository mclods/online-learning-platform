package com.mclods.online_learning_platform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Course Title cannot be blank")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Course Description cannot be bank")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Course Price cannot be null")
    @Column(name = "price")
    private Double price;

    @NotNull(message = "Course Level cannot be null")
    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private CourseLevel level;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> students;

    @ToString.Exclude
    @NotNull(message = "Course does not have a valid instructor")
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(mappedBy = "course")
    private Set<Module> modules;

    @ManyToMany
    @JoinTable(
            name = "course_tag",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    public Course(String title, String description, Double price, CourseLevel level,
                  LocalDateTime createdAt, Instructor instructor) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.level = level;
        this.createdAt = createdAt;
        this.instructor = instructor;
    }

    public enum CourseLevel {
        BEGINNER, INTERMEDIATE, ADVANCED
    }
}
