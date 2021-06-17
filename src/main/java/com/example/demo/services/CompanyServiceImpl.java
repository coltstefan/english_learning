package com.example.demo.services;

import com.example.demo.domain.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findCompanyByName(String name) {
        return companyRepository.findCompanyByName(name);
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findCompanyById(id);
    }
}
