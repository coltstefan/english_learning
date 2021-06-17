package com.example.demo.services;

import com.example.demo.domain.Company;
import com.example.demo.domain.Group;

import java.util.List;

public interface GroupService {
    Group save(Group g);
    List<Group> findAll();
    List<Group> findGroupsByCompany(Company c);
    Group findGroupById(Long id);
}
