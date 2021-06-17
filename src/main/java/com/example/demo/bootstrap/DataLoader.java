package com.example.demo.bootstrap;

import com.example.demo.domain.Company;
import com.example.demo.domain.Group;
import com.example.demo.domain.Student;
import com.example.demo.domain.Teacher;
import com.example.demo.services.CompanyService;
import com.example.demo.services.GroupService;
import com.example.demo.services.StudentService;
import com.example.demo.services.TeacherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CompanyService companyService;
    private final StudentService studentService;
    private final GroupService groupService;
    private final TeacherService teacherService;

    public DataLoader(CompanyService companyService, StudentService studentService, GroupService groupService, TeacherService teacherService) {
        this.companyService = companyService;
        this.studentService = studentService;
        this.groupService = groupService;
        this.teacherService = teacherService;
    }


    @Override
    public void run(String... args) throws Exception {


        Company c1 = new Company("IBM");

        Company c2 = new Company("Microsoft");

        Student s1 = new Student("Stefan" , "Advanced");
        Student s2 = new Student("Andrei" , "Beginner");
        Student s5 = new Student("Mario" , "Beginner");
        Student s6 = new Student("Radu" , "Advanced");
        Student s7 = new Student("Denis" , "Beginner");
        Student s8 = new Student("Viorel" , "Advanced");

        Student s3 = new Student("Marius" , "Intermediate");
        Student s4 = new Student("Albert" , "Beginner");


        Group g1 = new Group("Beginner");
        Group g2 = new Group("Advanced");
        Group g3 = new Group("Intermediate");

        Teacher t1 = new Teacher("Maria Elena");
        Teacher t2 = new Teacher("Gheormesu Maria");
        Teacher t3 = new Teacher("Soare Roxana");

        g1.addStudent(s2);
        g2.addStudent(s1);
        g1.addStudent(s5);
        g1.addStudent(s7);

        g1.setTeacher(t1);
        g2.setTeacher(t1);
        g3.setTeacher(t1);





        c1.addGroup(g1);
        c1.addGroup(g2);

        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s5);
        c1.addStudent(s6);
        c1.addStudent(s7);
        c1.addStudent(s2);
        c1.addStudent(s8);

        c2.addStudent(s3);
        c2.addStudent(s4);


        teacherService.save(t1);
        teacherService.save(t2);
        teacherService.save(t3);

        studentService.save(s1);
        studentService.save(s2);
        studentService.save(s3);
        studentService.save(s4);
        studentService.save(s5);
        studentService.save(s6);
        studentService.save(s7);

        groupService.save(g1);
        groupService.save(g2);


        companyService.save(c1);
        companyService.save(c2);






        System.out.println(companyService.findAll());
        //System.out.println(companyService.findCompanyById(2L).getGroupsList());





    }
}
