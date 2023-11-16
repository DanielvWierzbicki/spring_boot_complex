package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.Student;

public interface IStudent {
    List<Student> getStudents();
    public Student getStudentById(Long id);
    Student registerNewStudent(Student student);
    void modifyStudent(Long id, Student student);
    void deleteStudent(Long id);
}
