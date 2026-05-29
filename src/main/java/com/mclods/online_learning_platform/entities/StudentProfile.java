package com.mclods.online_learning_platform.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId("id")
    private Student student;
}
