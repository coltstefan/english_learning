package com.example.demo.serviceImpl;


import com.example.demo.domain.Student;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @InjectMocks StudentServiceImpl studentService;
    @Mock StudentRepository studentRepository;
    @Mock CompanyRepository companyRepository;

    @Test
    public void getAll() throws Exception{
        Student student = new Student("Stefan" , "Beginner");

        List<Student> mockedDBReturnedList = Arrays.asList(student);

        Mockito.when(studentRepository.findAll()).thenReturn(mockedDBReturnedList);

        List<Student> actualOutput = studentRepository.findAll();
        System.out.println(mockedDBReturnedList.size());
        System.out.println(studentRepository.findAll());

        Assert.assertEquals(mockedDBReturnedList.size() , actualOutput.size());
        Assert.assertEquals(mockedDBReturnedList.get(0).getName() , actualOutput.get(0).getName());



    }

}
