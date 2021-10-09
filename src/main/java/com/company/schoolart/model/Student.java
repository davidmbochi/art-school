package com.company.schoolart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity(name = "art_students")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "parent_email",nullable = false)
    private String parentEmail;

    @Column(name = "dob")
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(name = "student_status")
    private StudentStatus studentStatus;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    },
    fetch = FetchType.EAGER)
    Group group;

    public Student(String studentName,
                   String parentName,
                   String parentEmail,
                   LocalDate dob,
                   StudentStatus studentStatus) {
        this.studentName= studentName;
        this.parentName = parentName;
        this.parentEmail = parentEmail;
        this.dob = dob;
        this.studentStatus = studentStatus;
    }
}
