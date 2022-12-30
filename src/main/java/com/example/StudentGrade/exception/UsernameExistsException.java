package com.example.StudentGrade.exception;

public class UsernameExistsException extends RuntimeException {
    public UsernameExistsException(String exceptionText) {
        super("Fail to register as " + exceptionText);
    }
}
