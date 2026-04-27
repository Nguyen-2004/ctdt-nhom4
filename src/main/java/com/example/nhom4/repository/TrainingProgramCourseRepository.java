package com.example.nhom4.repository;

import com.example.nhom4.model.entity.TrainingProgramCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TrainingProgramCourseRepository extends JpaRepository<TrainingProgramCourse, UUID> {
}