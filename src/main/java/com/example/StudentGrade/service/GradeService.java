package com.example.StudentGrade.service;

import java.util.List;

import com.example.StudentGrade.entity.Grade;

public interface GradeService {
    Grade addGrade(Grade grade, Long studentId, Long courseId);

    Grade getGrade(Long studentId, Long courseId);

    Grade updateGrade(Grade grade, Long studentId, Long courseId);

    void deleteGrade(Long studentId, Long courseId);

    List<Grade> getAllStudentGrades(Long studentId);

    List<Grade> getAllCourseGrades(Long courseId);

    List<Grade> getAllGrades();
}
