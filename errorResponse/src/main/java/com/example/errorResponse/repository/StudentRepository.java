package com.example.errorResponse.repository;


import com.example.errorResponse.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StudentRepository { // interface 한번...
    Set<Student> students = new HashSet<>();

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> getAll() {
        return students.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
