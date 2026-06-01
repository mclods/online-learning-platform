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
@Table(name = "submission")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "score")
    private Double score;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @NotNull(message = "Submission does not have a valid assignment")
    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @NotNull(message = "Submission does not have a valid student")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
