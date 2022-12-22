package com.example.StudentGrade.exception;

public class GradeNotFoundException extends RuntimeException {
    public GradeNotFoundException(Long studentId, Long courseId) {
        super("Either " + studentId + " or " + courseId + " does not exist!");
    }
}
