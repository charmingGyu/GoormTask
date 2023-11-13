package com.example.errorResponse.controller;


import com.example.errorResponse.entity.ApiResponse;
import com.example.errorResponse.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Data
    @AllArgsConstructor
    static class Student {
        private String name;
        private int score;
    }

    @PostMapping("/student")
    public ApiResponse add(@RequestParam String name, @RequestParam int score) {
        studentService.addStudent(name, score);

        return makeResponse(studentService.addStudent(name, score));
    }
    @PostMapping("/students")
    public ApiResponse getAll() {
        return makeResponse(studentService.getAll());
    }

    public <T> ApiResponse<T> makeResponse(List<T> result) {
        return new ApiResponse<>(result);
    }
    public <T> ApiResponse<T> makeResponse(T result) {
        return new ApiResponse<>(Collections.singletonList(result));
    }
}
