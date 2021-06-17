package com.example.demo.controllers;


import com.example.demo.domain.Company;
import com.example.demo.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String getCompanies(Model model){

        model.addAttribute("companyList" , companyService.findAll());

        return "companies_list";
    }

    @GetMapping("/newCompany")
    public String newCompany(Model model){
        Company company = new Company();

        model.addAttribute("company" , company);

        return "new_company";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company){
        companyService.save(company);

        return "redirect:/";
    }


}
