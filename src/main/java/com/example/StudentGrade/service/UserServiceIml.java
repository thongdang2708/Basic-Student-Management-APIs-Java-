package com.example.StudentGrade.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.StudentGrade.entity.User;
import com.example.StudentGrade.exception.UserNotFoundWithIdException;
import com.example.StudentGrade.exception.UserNotFoundWithName;
import com.example.StudentGrade.exception.UsernameExistsException;
import com.example.StudentGrade.repository.UserRepository;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User getUser(Long id) {

        // System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundWithIdException(id);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundWithName(username);
        }
    }

    @Override
    public User register(User user) {
        if (userRepository.existsUserByUsername(user.getUsername())) {
            throw new UsernameExistsException(" this username exists already");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            return userRepository.save(user);
        }
    }
}
