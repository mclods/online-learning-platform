package com.mclods.online_learning_platform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Instructor Name cannot be blank")
    @Column(name = "name")
    private String name;

    @Email(message = "Instructor Email is not valid")
    @Column(name = "email")
    private String email;

    @Column(name = "bio")
    private String bio;

    @OneToMany(mappedBy = "instructor")
    private Set<Course> courses;
}
