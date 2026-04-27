package com.example.nhom4.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.nhom4.model.entity.TrainingProgram;
import com.example.nhom4.repository.TrainingProgramRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainingProgramService {

    private final TrainingProgramRepository repository;

    public List<TrainingProgram> getAll() {
        return repository.findByIsActiveTrue();
    }

    public TrainingProgram getById(UUID id) {
        return repository.findById(id).orElseThrow();
    }

    public List<TrainingProgram> getByMajor(UUID majorId) {
        return repository.findByMajorId(majorId);
    }

    public TrainingProgram create(TrainingProgram tp) {
        tp.setCreatedAt(LocalDateTime.now());
        tp.setIsActive(true);
        return repository.save(tp);
    }

    public TrainingProgram update(UUID id, TrainingProgram req) {
        TrainingProgram tp = getById(id);

        tp.setProgramName(req.getProgramName());
        tp.setProgramNameEn(req.getProgramNameEn());
        tp.setTotalCredits(req.getTotalCredits());
        tp.setUpdatedAt(LocalDateTime.now());

        return repository.save(tp);
    }

    public void delete(UUID id) {
        TrainingProgram tp = getById(id);
        tp.setDeletedAt(LocalDateTime.now());
        tp.setIsActive(false);
        repository.save(tp);
    }
}
