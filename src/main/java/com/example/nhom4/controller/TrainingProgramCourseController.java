package com.example.nhom4.controller;

import com.example.nhom4.model.entity.TrainingProgramCourse;
import com.example.nhom4.service.TrainingProgramCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/training-program-courses")
public class TrainingProgramCourseController {

    private final TrainingProgramCourseService service;

    public TrainingProgramCourseController(TrainingProgramCourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<TrainingProgramCourse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TrainingProgramCourse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public TrainingProgramCourse create(@RequestBody TrainingProgramCourse obj) {
        return service.create(obj);
    }

    @PutMapping("/{id}")
    public TrainingProgramCourse update(@PathVariable UUID id, @RequestBody TrainingProgramCourse obj) {
        return service.update(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}