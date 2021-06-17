package com.example.demo.services;

import com.example.demo.domain.Company;

import java.util.List;

public interface CompanyService {

    Company save(Company company);
    List<Company> findAll();
    Company findCompanyByName(String name);
    Company findCompanyById(Long id);


}
