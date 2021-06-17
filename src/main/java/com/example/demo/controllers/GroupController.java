package com.example.demo.controllers;


import com.example.demo.domain.Company;
import com.example.demo.domain.Group;
import com.example.demo.domain.Student;
import com.example.demo.domain.Teacher;
import com.example.demo.services.CompanyService;
import com.example.demo.services.GroupService;
import com.example.demo.services.StudentService;
import com.example.demo.services.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/groups")
public class GroupController<chosenList> {

    private final GroupService groupService;
    private final CompanyService companyService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public GroupController(GroupService groupService, CompanyService companyService, StudentService studentService, TeacherService teacherService) {
        this.groupService = groupService;
        this.companyService = companyService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }


    @GetMapping("/{id}")
    public String getGroups(@PathVariable Long id , Model model){

        model.addAttribute("company" , companyService.findCompanyById(id));
        model.addAttribute("groupList" , groupService.findGroupsByCompany(companyService.findCompanyById(id)));
        return "group_list";

    }

    @GetMapping("/students/{id_company}/{id_group}")
    public String getStudentsByGroup( @PathVariable Long id_company, @PathVariable Long id_group , Model model){
        Group group = groupService.findGroupById(id_group);
        model.addAttribute("company" , companyService.findCompanyById(id_company));
        model.addAttribute("group" , group);
        model.addAttribute("studentList" , groupService.findGroupById(id_group).getStudentsList());

        return "students_by_group";
    }

    @GetMapping("/addStudent/companyId={id_company}/groupId={id_group}")
    public String addStudent(@PathVariable Long id_company , @PathVariable Long id_group , Model model){

        List<Student> studentsWithoutGroup = new ArrayList<>();

        for(Student student : companyService.findCompanyById(id_company).getStudentsList()){

            if (student.getGrupa() == null){
                studentsWithoutGroup.add(student);
            }
        }
        //System.out.println(studentsWithoutGroup);
        List<Student> chosenList = new ArrayList<>();
        Group grupaNoua = new Group();

        model.addAttribute("company" , companyService.findCompanyById(id_company));
        model.addAttribute("group" , groupService.findGroupById(id_group));
        model.addAttribute("grupaNoua" , grupaNoua);
        model.addAttribute("studentAles" , chosenList);
        model.addAttribute("students" , studentsWithoutGroup);

        return "addstud_to_group";

    }

    @PostMapping("saveStudents/{id_company}/{id_group}")
    public String saveStudent(@PathVariable Long id_company , @PathVariable Long id_group , @ModelAttribute("groupaNoua") Group group){


        for(Student student : group.getStudentsList()){
            groupService.findGroupById(id_group).addStudent(student);
            student.setGrupa(groupService.findGroupById(id_group));
            student.setCompany(companyService.findCompanyById(id_company));
            studentService.save(student);
        }

        groupService.save(groupService.findGroupById(id_group));



        return "redirect:/groups/students/{id_company}/{id_group}";
    }

    @GetMapping("/addGroup/{id_company}")
    public String addGroup(@PathVariable Long id_company , Model model ){

        Company company = companyService.findCompanyById(id_company);
        Group group = new Group();

//        List<Teacher> teacherList = teacherService.findAll();
//
//        List<Teacher> availableTeachers = new ArrayList<>();
//
//        for(Teacher teacher : teacherList){
//            if(teacher.getNrGroups()<3){
//                availableTeachers.add(teacher);
//            }
//        }
//
//        model.addAttribute("teachersAvailable" , availableTeachers);
        model.addAttribute("company" , company);
        model.addAttribute("group" , group);

        return "add_group";
    }

    @PostMapping("/addGroup/saveGroup/{id_company}")
    public String saveGroup(@PathVariable Long id_company , @ModelAttribute("group") Group group){

        List<Teacher> teacherList = teacherService.findAll();

        List<Teacher> availableTeachers = new ArrayList<>();

        for(Teacher teacher : teacherList){
            if(teacher.getNrGroups()<=3){
                availableTeachers.add(teacher);
            }
        }

        Random rand = new Random();
        System.out.println(availableTeachers);
        System.out.println(availableTeachers.size());
        int index = rand.nextInt(availableTeachers.size());

        group.setTeacher(availableTeachers.get(index));
        System.out.println(index);


        group.setCompany(companyService.findCompanyById(id_company));
        groupService.save(group);

        return "redirect:/groups/{id_company}";


    }

}
