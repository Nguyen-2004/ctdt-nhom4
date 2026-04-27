package com.example.nhom4.controller;

import com.example.nhom4.model.entity.Course;
import com.example.nhom4.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return service.create(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable UUID id, @RequestBody Course course) {
        return service.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}