package com.example.demo.services;


import com.example.demo.domain.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher save(Teacher teacher);
    List<Teacher> findAll();
    Teacher findTeacherById(Long id);


}
