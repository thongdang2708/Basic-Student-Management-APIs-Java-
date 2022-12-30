package com.example.StudentGrade.service;

import com.example.StudentGrade.entity.User;

public interface UserService {
    User getUser(Long id);

    User register(User user);

    User getUserByUsername(String username);
}
