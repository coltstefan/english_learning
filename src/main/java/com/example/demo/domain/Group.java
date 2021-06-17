package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"company" , "student" , "teacher"})
@ToString(exclude = {"company","student" , "teacher"})
@NoArgsConstructor
@Table(name = "grupa")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    private String level;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Teacher teacher;

    @OneToMany( mappedBy = "grupa" , cascade = CascadeType.ALL)
    private Set<Student> studentsList = new HashSet<>();

    public Group(String level) {
        this.level = level;
    }

    public void addStudent(Student student){
        student.setGrupa(this);
        studentsList.add(student);

    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        teacher.setNrGroups(teacher.getNrGroups()+1);
    }
}
