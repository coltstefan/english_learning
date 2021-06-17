package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"company" , "grupa"})
@ToString(exclude = {"company" , "grupa"})
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String level;


    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL)
    private Group grupa;


    public Student(String name, String level) {
        this.name = name;
        this.level = level;
    }
}
