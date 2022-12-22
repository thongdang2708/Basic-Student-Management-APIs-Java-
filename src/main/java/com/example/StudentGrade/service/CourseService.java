package com.example.StudentGrade.service;

import java.util.List;
import java.util.Set;

import com.example.StudentGrade.entity.Course;
import com.example.StudentGrade.entity.Student;

public interface CourseService {
    Course addCourse(Course course);

    Course getCourse(Long id);

    Course updateCourse(Course course, Long id);

    void deleteCourse(Long id);

    Course addStudentToCourse(Long courseId, Long studentId);

    Set<Student> getEnrolledStudents(Long courseId);

    List<Course> getAllCourses();
}
