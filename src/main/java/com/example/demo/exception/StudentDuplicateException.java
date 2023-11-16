package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class StudentDuplicateException extends RuntimeException {
    private HttpStatus status;
    public StudentDuplicateException(HttpStatus status, String name, String email) {
        super("Student with name: " + name + " or email: " + email + " already exists");
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
