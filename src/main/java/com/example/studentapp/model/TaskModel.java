package com.example.studentapp.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 1. Stwórz nowy model o nazwie klasy TaskModel dodając w nim odpowiednie pola jakie uwzględniliśmy w
 * widoku html  adresie url /addTask tworząc zarazem relacje OneToMany w stosunku do StudentModel(OneToMany) TaskModel(ManyToOne)
 * pola:
 *
 * @DateTimeFormat(pattern = "yyyy-MM-dd")
 * private Date deadline;
 * private String description;
 * private String color;
 * @DateTimeFormat(pattern = "yyyy-MM-dd")
 * private Date creationDate;
 * 2. Stwórz Interfejs dla ww modelu CRUD a w package service klasę TaskService i oznacz ją dopisując w niej potrzebne metody. Użyj ją w controllerze - robiąc sobie tym dostęp do niego)
 * 3. Stwórz mapowanie z metodą pozwalającą na zapis danego taska, wyświetlewnie wszystkich tasków i edycje wybranego taska oraz usunięcie. CRUD
 */
@Entity
@Data
@Slf4j
public class TaskModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    private String color;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "creation_Date")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentModel studentModel;


}
