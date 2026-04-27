package com.example.nhom4.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nhom4.model.entity.Major;

public interface MajorRepository extends JpaRepository<Major, UUID> {

    List<Major> findByIsActiveTrue();

    boolean existsByMajorCode(String majorCode);
}
