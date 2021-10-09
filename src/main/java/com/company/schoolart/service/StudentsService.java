package com.company.schoolart.service;

import com.company.schoolart.model.Student;

import java.util.List;

public interface StudentsService {
    List<Student> findAllStudents();
    Student findStudentById(int studentId);
    Student addStudent(Student student);
    Student updateStudentName(Student student);
    Student updateStudentGroup(Student student);
    Student markStudentInactive(Student student);
}
