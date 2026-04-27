package com.example.nhom4.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "training_program_courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgramCourse {

    @Id
    private UUID id;

    private UUID training_program_id;

    private UUID course_id;

    private Integer semester_number;
    private Integer year_number;

    private Boolean is_required;

    private String group_code;

    private Double credits;

    private UUID prerequisite_course_id;

    private Boolean is_prerequisite_required;

    private String note;

    private Integer sort_order;

    private String status;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private UUID created_by;
    private UUID updated_by;

    private LocalDateTime deleted_at;
    private UUID deleted_by;

    private Boolean is_active;
}