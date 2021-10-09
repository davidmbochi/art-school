package com.company.schoolart.service;

import com.company.schoolart.model.Student;
import com.company.schoolart.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentsService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(int studentId) {
        return studentRepository.findStudentById(studentId);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentName(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentGroup(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student markStudentInactive(Student student) {
        return studentRepository.save(student);
    }
}
