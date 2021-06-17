package com.example.demo.repository;

import com.example.demo.domain.Company;
import com.example.demo.domain.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group,Long> {

    @Query("select g from Group g")
    List<Group> findALL();

    @Query("select g from Group g where g.company = :c")
    List<Group>findGroupsByCompany(Company c);

    @Query("select g from Group g where g.id = :id")
    Group findGroupById(Long id);

}
