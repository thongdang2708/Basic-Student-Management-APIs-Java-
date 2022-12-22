package com.example.StudentGrade.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long courseId) {
        super("This course id" + courseId + " does not exist");
    }
}
