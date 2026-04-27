package com.example.nhom4.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.nhom4.model.entity.Major;
import com.example.nhom4.repository.MajorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MajorService {

    private final MajorRepository majorRepository;

    public List<Major> getAll() {
        return majorRepository.findByIsActiveTrue();
    }

    public Major getById(UUID id) {
        return majorRepository.findById(id).orElseThrow();
    }

    public Major create(Major major) {
        major.setCreatedAt(LocalDateTime.now());
        major.setIsActive(true);
        return majorRepository.save(major);
    }

    public Major update(UUID id, Major request) {
        Major major = getById(id);

        major.setMajorName(request.getMajorName());
        major.setDescription(request.getDescription());
        major.setUpdatedAt(LocalDateTime.now());

        return majorRepository.save(major);
    }

    public void delete(UUID id) {
        Major major = getById(id);
        major.setDeletedAt(LocalDateTime.now());
        major.setIsActive(false);
        majorRepository.save(major);
    }
}
