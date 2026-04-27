package com.example.nhom4.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "training_programs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingProgram {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "code", length = 50)
    private String programCode;

    @Column(name = "name")
    private String programName;

    @Column(name = "name_en")
    private String programNameEn;

    @Column(name = "major_id")
    private UUID majorId;

    @Column(name = "department_id")
    private UUID departmentId;

    @Column(name = "degree_level")
    private String degreeLevel;

    @Column(name = "education_type")
    private String educationType;

    @Column(name = "total_credits")
    private BigDecimal totalCredits;

    @Column(name = "required_credits")
    private BigDecimal requiredCredits;

    @Column(name = "elective_credits")
    private BigDecimal electiveCredits;

    @Column(name = "internship_credits")
    private BigDecimal internshipCredits;

    @Column(name = "thesis_credits")
    private BigDecimal thesisCredits;

    @Column(name = "admission_year")
    private LocalDate admissionYear;

    @Column(name = "duration_years")
    private BigDecimal durationYears;

    @Column(name = "max_duration_years")
    private BigDecimal maxDurationYears;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String objectives;

    @Column(name = "learning_outcomes", columnDefinition = "NVARCHAR(MAX)")
    private String learningOutcomes;

    private String version;
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "updated_by")
    private UUID updatedBy;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    private UUID deletedBy;

    @Column(name = "is_active")
    private Boolean isActive;
}
