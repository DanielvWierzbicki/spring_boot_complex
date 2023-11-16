package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentDuplicateException.class)
    public ResponseEntity<CustomErrorResponse> handleStudentDuplicateException(StudentDuplicateException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                ex.getStatus().value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleStudentNotFoundException(StudentNotFoundException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                ex.getStatus().value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<CustomErrorResponse> handleStudentNotFoundException(CustomException ex) {
//        CustomErrorResponse errorResponse = new CustomErrorResponse(
//                ex.getStatus().value(),
//                ex.getMessage()
//        );
//        return new ResponseEntity<>(errorResponse, ex.getStatus());
//    }

}

