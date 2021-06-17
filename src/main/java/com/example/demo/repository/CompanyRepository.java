package com.example.demo.repository;

import com.example.demo.domain.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query("SELECT c FROM Company c")
    List<Company> findAll();

    @Query("SELECT c FROM Company c where c.name = :name")
    Company findCompanyByName(String name);

    @Query("SELECT c FROM Company c where c.id = :id")
    Company findCompanyById(Long id);




}
