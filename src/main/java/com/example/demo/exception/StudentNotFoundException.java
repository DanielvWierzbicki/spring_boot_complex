package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends RuntimeException {
    private HttpStatus status;
    public StudentNotFoundException(HttpStatus status, Long studentId) {
        super("Student with ID " + studentId + " not found");
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
