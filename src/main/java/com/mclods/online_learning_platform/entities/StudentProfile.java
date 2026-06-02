package com.mclods.online_learning_platform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_profile")
public class StudentProfile {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ToString.Exclude
    @NotNull(message = "Student Profile does not have a valid student")
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Student student;

    public StudentProfile(String bio, String avatarUrl, LocalDate dateOfBirth,  Student student) {
        this.bio = bio;
        this.avatarUrl = avatarUrl;
        this.dateOfBirth = dateOfBirth;
        this.student = student;
    }
}
