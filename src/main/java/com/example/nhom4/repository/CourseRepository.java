package com.example.nhom4.repository;

import com.example.nhom4.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}