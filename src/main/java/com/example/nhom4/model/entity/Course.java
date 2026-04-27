package com.example.nhom4.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    private UUID id;

    private UUID department_id;

    @Column(unique = true)
    private String course_code;

    private String course_name;
    private String course_name_en;

    private Double credits;
    private String course_type;

    private Double theory_hours;
    private Double practice_hours;
    private Double self_study_hours;
    private Double internship_hours;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private UUID created_by;
    private UUID updated_by;

    private LocalDateTime deleted_at;
    private UUID deleted_by;

    private Boolean is_active;
}