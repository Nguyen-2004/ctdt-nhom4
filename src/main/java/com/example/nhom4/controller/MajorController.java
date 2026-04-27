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

import com.example.nhom4.model.entity.Major;
import com.example.nhom4.service.MajorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/majors")
@RequiredArgsConstructor
public class MajorController {

    private final MajorService service;

    @GetMapping
    public List<Major> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Major getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Major create(@RequestBody Major major) {
        return service.create(major);
    }

    @PutMapping("/{id}")
    public Major update(@PathVariable UUID id, @RequestBody Major major) {
        return service.update(id, major);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
