package com.example.StudentGrade.exception;

public class UserNotFoundWithName extends RuntimeException {
    public UserNotFoundWithName(String username) {
        super("This username " + username + " does not exist");
    }
}
