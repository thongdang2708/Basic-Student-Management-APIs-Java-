package com.example.StudentGrade;

import java.util.Arrays;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.StudentGrade.exception.CourseNotFoundException;
import com.example.StudentGrade.exception.EnrolledNotFoundException;
import com.example.StudentGrade.exception.ErrorResponse;
import com.example.StudentGrade.exception.GradeNotFoundException;
import com.example.StudentGrade.exception.StudentNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ StudentNotFoundException.class, CourseNotFoundException.class, GradeNotFoundException.class,
            EnrolledNotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(RuntimeException ex) {
        ErrorResponse errors = new ErrorResponse(Arrays.asList(ex.getLocalizedMessage()));

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {

        ErrorResponse errors = new ErrorResponse(Arrays.asList("Cannot delete non-existing resource"));

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorResponse errors = new ErrorResponse(
                Arrays.asList("Data Integrity Violation: we cannot process your request"));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
