package com.example.nhom4.service;

import com.example.nhom4.model.entity.Course;
import com.example.nhom4.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public Course getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Course create(Course course) {
        course.setId(UUID.randomUUID());
        return repository.save(course);
    }

    public Course update(UUID id, Course course) {
        course.setId(id);
        return repository.save(course);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}