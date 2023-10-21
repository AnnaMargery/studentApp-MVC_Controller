package com.example.studentapp.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Slf4j
@Data
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name= "first_name")
    private String firstName;
    @Column (name= "last_name")
    private String lastName;
    @Column (name= "git_hub")
    private String gitHub;
    @Column (name= "start")
    private String start;




}
