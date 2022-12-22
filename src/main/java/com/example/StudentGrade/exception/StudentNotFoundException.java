package com.example.StudentGrade.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long studentId) {
        super("This studentid " + studentId + " does not exist");
    }
}
