package com.example.StudentGrade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentGrade.entity.Course;

import jakarta.transaction.Transactional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    @Transactional
    void deleteById(Long id);
}
