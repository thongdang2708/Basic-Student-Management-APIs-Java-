package com.example.StudentGrade.security;

public class SecurityConstants {
    public static final String registerPath = "/user/register";
    public static final String getUserPath = "/user/*";
    public static final int TOKEN_EXPIRATION = 7200000;
    public static final String SECRET_KEY = "student_project";
}
