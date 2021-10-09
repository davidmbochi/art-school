package com.company.schoolart.controller;

import com.company.schoolart.model.Group;
import com.company.schoolart.model.Student;
import com.company.schoolart.repository.GroupRepository;
import com.company.schoolart.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/student")
public class StudentController {

    private final StudentsService studentsService;
    private final GroupRepository groupRepository;

    //Get all students
    @GetMapping("/find/all")
    List<Student> getAllStudents(){
        return studentsService.findAllStudents();
    }

    //Get a student with a given id
    @GetMapping("/find/{id}")
    Student findStudentById(@PathVariable("id") int id){
        return studentsService.findStudentById(id);
    }

    //add a student successfully and
    //add a student with a missing required field.
    //The operation should fail with a proper error status code
    @PostMapping("/add")
    Student addStudent(@RequestBody Student student){
        return studentsService.addStudent(student);
    }

    //update the name of a student
    @PutMapping("/update/name/{id}")
    Student updateStudentName(@RequestBody Student student,@PathVariable("id") int id){
        Student john = studentsService.findStudentById(id);
        john.setStudentName(student.getStudentName());
        return  studentsService.updateStudentName(john);
    }

    //update the group of a student
    @PutMapping("/update/group/{id}")
    Student updateStudentGroup(@RequestBody Student student,@PathVariable("id") int id){
        Student john = studentsService.findStudentById(id);
        Group architecture = groupRepository.findGroupByGroupName(student.getGroup().getGroupName());
        john.setGroup(architecture);
        return studentsService.updateStudentGroup(john);
    }

    //mark a student as inactive
    @PutMapping("/update/status/{id}")
    Student markStudentInactive(@RequestBody Student student, @PathVariable("id") int id){
        Student john = studentsService.findStudentById(id);
        john.setStudentStatus(student.getStudentStatus());
        return studentsService.markStudentInactive(john);
    }
}
