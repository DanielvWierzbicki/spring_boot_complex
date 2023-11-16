package com.example.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.StudentDuplicateException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;
import com.example.demo.validator.EmailValidator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final EmailValidator emailValidator;

    public StudentService(StudentRepository studentRepository, EmailValidator emailValidator) {
        this.studentRepository = studentRepository;
        this.emailValidator = emailValidator;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new StudentNotFoundException(HttpStatus.BAD_REQUEST, id);
        }
        return student;
    }

    public Student addNewStudent(Student student) {
        validateStudent(student);
        studentRepository.save(student);
        log.info("Student with NAME: {} added.", student.getName().toUpperCase());
        return student;
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(HttpStatus.BAD_REQUEST, id);
        }
        studentRepository.deleteById(id);
        log.info("Student with ID: {} deleted.", id.toString().toUpperCase());
    }

    @Transactional
    public void modifyStudent(Long id, Student student) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(HttpStatus.BAD_REQUEST, id);
        }
        validateStudent(student);
        Student studentFromRepo = studentRepository.findStudentById(id);
        studentFromRepo.setName(student.getName());
        studentFromRepo.setEmail(student.getEmail());
        studentFromRepo.setAge(student.getAge());
        studentRepository.save(studentFromRepo);
        log.info("Student with ID: {} modified.", id.toString().toUpperCase());
    }

    private void validateStudent(Student student) {
        String name = student.getName();
        String email = student.getEmail();

        if (!emailValidator.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (studentRepository.findStudentByNameOrEmail(name, email).isPresent()) {
            throw new StudentDuplicateException(HttpStatus.BAD_REQUEST, name, email);
        }
    }
}

