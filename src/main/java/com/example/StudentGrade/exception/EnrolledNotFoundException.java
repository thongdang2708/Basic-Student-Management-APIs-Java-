package com.example.StudentGrade.exception;

public class EnrolledNotFoundException extends RuntimeException {
    public EnrolledNotFoundException(Long studentId, Long courseId) {
        super("This student cannot add grade as he/she does not register the course with id: " + courseId);
    }
}
