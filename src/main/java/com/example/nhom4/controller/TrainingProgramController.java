package com.example.nhom4.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nhom4.model.entity.TrainingProgram;
import com.example.nhom4.service.TrainingProgramService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/training-programs")
@RequiredArgsConstructor
public class TrainingProgramController {

    private final TrainingProgramService service;

    @GetMapping
    public List<TrainingProgram> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TrainingProgram getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/major/{majorId}")
    public List<TrainingProgram> getByMajor(@PathVariable UUID majorId) {
        return service.getByMajor(majorId);
    }

    @PostMapping
    public TrainingProgram create(@RequestBody TrainingProgram tp) {
        return service.create(tp);
    }

    @PutMapping("/{id}")
    public TrainingProgram update(@PathVariable UUID id, @RequestBody TrainingProgram tp) {
        return service.update(id, tp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
