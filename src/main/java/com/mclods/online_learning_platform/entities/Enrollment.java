package com.mclods.online_learning_platform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enrollment")
public class Enrollment {
    @EmbeddedId
    private EnrollmentId id;

    @NotNull(message = "Enrollment does not have a valid student")
    @ManyToOne
    @JoinColumn(name = "student_id")
    @MapsId("studentId")
    private Student student;

    @NotNull(message = "Enrollment does not have a valid course")
    @ManyToOne
    @JoinColumn(name = "course_id")
    @MapsId("courseId")
    private Course course;

    @Column(name = "enrolled_at")
    private LocalDateTime enrolledAt;

    @Column(name = "status")
    private String status;
}
