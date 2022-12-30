package com.example.StudentGrade.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentGrade.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsUserByUsername(String username);

    Optional<User> findByUsername(String username);
}
