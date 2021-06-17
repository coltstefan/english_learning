package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"student" , "grupa"} )
@ToString(exclude = {"student" , "grupa"})
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany( fetch = FetchType.EAGER , mappedBy = "company" , cascade = CascadeType.ALL)
    private Set<Student> studentsList = new HashSet<>();

    @OneToMany( fetch = FetchType.EAGER , mappedBy = "company" , cascade = CascadeType.ALL)
    private Set<Group> groupsList = new HashSet<>();

    public void addStudent(Student s){
        studentsList.add(s);
        s.setCompany(this);
    }

    public void addGroup(Group g){
        groupsList.add(g);
        g.setCompany(this);
    }

    public Company( String name) {
        this.name = name;
    }
}
