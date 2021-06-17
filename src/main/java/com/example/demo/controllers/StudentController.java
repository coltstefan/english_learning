package com.example.demo.controllers;


import com.example.demo.domain.Student;
import com.example.demo.services.CompanyService;
import com.example.demo.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final CompanyService companyService;

    public StudentController(StudentService studentService, CompanyService companyService) {
        this.studentService = studentService;
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public String getStudents(@PathVariable Long id ,  Model model){

        model.addAttribute("studentsList" , studentService.findStudentsByCompany(companyService.findCompanyById(id)));
        model.addAttribute("company" , companyService.findCompanyById(id));


        return "students_by_company";

    }

    @GetMapping("/newStudent/{id}")
    public String newStudent(@PathVariable Long id , Model model){

        Student student = new Student();
        model.addAttribute("student" , student);
        model.addAttribute("company" , companyService.findCompanyById(id));

        return "new_student";

    }

    @PostMapping("/newStudent/saveStudent/{id}")
    public String saveStudent(@PathVariable Long id , @ModelAttribute("student") Student student){
        student.setCompany(companyService.findCompanyById(id));
        studentService.save(student);
        return "redirect:/students/{id}";

    }

}
