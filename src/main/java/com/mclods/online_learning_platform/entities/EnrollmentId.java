package com.mclods.online_learning_platform.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentId implements Serializable {
    @Serial
    private static final long  serialVersionUID = 1L;

    private Integer studentId;

    private Integer courseId;
}
