package com.example.nhom4.service;

import com.example.nhom4.model.entity.TrainingProgramCourse;
import com.example.nhom4.repository.TrainingProgramCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrainingProgramCourseService {

    private final TrainingProgramCourseRepository repository;

    public TrainingProgramCourseService(TrainingProgramCourseRepository repository) {
        this.repository = repository;
    }

    public List<TrainingProgramCourse> getAll() {
        return repository.findAll();
    }

    public TrainingProgramCourse getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public TrainingProgramCourse create(TrainingProgramCourse obj) {
        obj.setId(UUID.randomUUID());
        return repository.save(obj);
    }

    public TrainingProgramCourse update(UUID id, TrainingProgramCourse obj) {
        obj.setId(id);
        return repository.save(obj);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}