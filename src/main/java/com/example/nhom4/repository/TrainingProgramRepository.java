package com.example.nhom4.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nhom4.model.entity.TrainingProgram;

public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, UUID> {

    List<TrainingProgram> findByIsActiveTrue();

    List<TrainingProgram> findByMajorId(UUID majorId);
}
