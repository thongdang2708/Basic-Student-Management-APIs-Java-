package com.example.StudentGrade.exception;

public class UserNotFoundWithIdException extends RuntimeException {
    public UserNotFoundWithIdException(Long id) {
        super("This user id " + id + " does not exist!");
    }
}
