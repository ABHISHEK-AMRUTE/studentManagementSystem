package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    ResponseEntity<Student> addStudent( Student student);
    Student updateStudent( Student student);
    Student getStundentById(Long id);
    void deleteStudent( Long id );
    Student save( Student student);
}
