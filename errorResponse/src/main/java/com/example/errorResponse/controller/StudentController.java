package com.example.errorResponse.controller;


import com.example.errorResponse.entity.ApiResponse;
import com.example.errorResponse.entity.ErrorCode;
import com.example.errorResponse.service.StudentService;
import com.example.exception.CustomException;
import com.example.exception.InputRestriction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    public ApiResponse add(@RequestParam("name") String name,
                           @RequestParam("score") int score) {
        if (score >= 6) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "score는 6 이상을 입력할 수 없습니다.", new InputRestriction(6));
        }
//        studentService.addStudent(name, score);

        return makeResponse(studentService.addStudent(name, score));
    }

    @PostMapping("/students")
    public ApiResponse getAll() {
        return makeResponse(studentService.getAll());
    }

    @GetMapping("/students/{score}")
    public ApiResponse getScoreStudent(@PathVariable("score") int score) {
        return makeResponse(studentService.getScoreStudent(score));
    }

    public <T> ApiResponse<T> makeResponse(List<T> result) {
        return new ApiResponse<>(result);
    }

    public <T> ApiResponse<T> makeResponse(T result) {

        return new ApiResponse<>(Collections.singletonList(result));
    }

    @ExceptionHandler(CustomException.class)
    public ApiResponse customExceptionHandler(HttpServletResponse response, CustomException customException) {
//        response.setStatus(customException.getErrorCode().getCode());

        return new ApiResponse(customException.getErrorCode().getCode(),
                customException.getErrorCode().getMessage(),
                customException.getData());

    }

}
