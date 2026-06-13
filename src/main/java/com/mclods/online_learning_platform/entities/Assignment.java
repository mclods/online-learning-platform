package com.mclods.online_learning_platform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Assignment Title cannot be blank")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Assignment Max Score cannot be null")
    @Min(value = 0, message = "Assignment Max Score should have a min value of 0")
    @Column(name = "max_score")
    private Double maxScore;

    @NotNull(message = "Assignment Due Date cannot be null")
    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @ToString.Exclude
    @NotNull(message = "Assignment does not have a valid module")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Module module;

    @OneToMany(mappedBy = "assignment")
    private Set<Submission> submissions;

    public Assignment(String title, Double maxScore, LocalDateTime dueDate, Module module) {
        this.title = title;
        this.maxScore = maxScore;
        this.dueDate = dueDate;
        this.module = module;
    }
}
