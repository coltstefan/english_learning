package com.example.demo.repository;

import com.example.demo.domain.Company;
import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {

    @Query("select s from Student s")
    List<Student> findAll();

    @Query("select s from Student s where s.id = :id")
    Student findStudentById(Long id);

    @Query("select s from Student s where s.company = :c")
    List<Student> findStudentsByCompany(Company c);


}
