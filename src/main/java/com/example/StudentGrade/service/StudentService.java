package com.example.StudentGrade.service;

import java.util.List;
import java.util.Set;

import com.example.StudentGrade.entity.Course;
import com.example.StudentGrade.entity.Student;

public interface StudentService {
    Student addStudent(Student student);

    Student getStudent(Long studentId);

    void updateStudent(Long studentId, Student student);

    void deleteStudent(Long studentId);

    Set<Course> getEnrolledCourses(Long studentId);

    List<Student> getAllStudents();

}
