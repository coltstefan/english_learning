package com.example.demo.services;

import com.example.demo.domain.Company;
import com.example.demo.domain.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);
    List<Student> findAll();
    Student findStudentById(Long id);
    List<Student> findStudentsByCompany(Company c);


}
