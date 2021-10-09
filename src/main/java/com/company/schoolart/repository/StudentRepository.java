package com.company.schoolart.repository;

import com.company.schoolart.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(int studentId);
    Student findStudentByStudentName(String studentName);
}
