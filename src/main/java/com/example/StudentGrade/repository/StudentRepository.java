package com.example.StudentGrade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentGrade.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
