package com.mclods.online_learning_platform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Module Title cannot be blank")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Module Order cannot be null")
    @Min(value = 0, message = "Module Order should have a min value of 0")
    @Column(name = "order_index")
    private Integer orderIndex;

    @NotNull(message = "Module does not have a valid course")
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "module")
    private Set<Assignment> assignments;
}
