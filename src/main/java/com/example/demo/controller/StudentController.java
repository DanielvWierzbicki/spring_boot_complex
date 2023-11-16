package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.example.demo.interfaces.IStudent;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController implements IStudent {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/all")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student registerNewStudent(@RequestBody @Valid Student student) {
        return studentService.addNewStudent(student);
    }

    @PutMapping(value = "/{id}")
    public void modifyStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        studentService.modifyStudent(id, student);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

}
