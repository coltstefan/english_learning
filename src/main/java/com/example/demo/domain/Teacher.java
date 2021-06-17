package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"company" , "grupa"})
@ToString(exclude = {"company" , "grupa"})
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int nrGroups;

    @OneToMany( fetch = FetchType.EAGER , mappedBy = "teacher" , cascade = CascadeType.ALL)
    private Set<Group> groupsList = new HashSet<>();

    public Teacher(String name) {
        this.name = name;
    }

    public void addGroup(Group group){
        groupsList.add(group);
        group.setTeacher(this);
        this.nrGroups++;

    }
}
