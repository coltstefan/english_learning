package com.example.demo.repository;

import com.example.demo.domain.Group;
import com.example.demo.domain.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {

    @Query("select t from Teacher t")
    List<Teacher> findAll();

    @Query("select t from Teacher t where t.id = :id")
    Teacher findTeacherById(Long id);


}
