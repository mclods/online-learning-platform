package com.mclods.online_learning_platform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Tag Name cannot be blank")
    @Column(name = "name")
    private String name;

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "tags")
    private Set<Course> courses;

    public Tag(String name) {
        this.name = name;
    }
}
