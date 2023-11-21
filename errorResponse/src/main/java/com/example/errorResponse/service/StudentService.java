package com.example.errorResponse.service;

import com.example.errorResponse.entity.Student;
import com.example.errorResponse.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;


    public Student addStudent(String name, int score) {
        Student student = new Student(name, score);
        studentRepository.add(student);

        return student;
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public List<Student> getScoreStudent(int score) {
        return studentRepository.get(score);
    }
}
