package com.example.StudentGrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentGrade.entity.Grade;
import com.example.StudentGrade.repository.GradeRepository;
import com.example.StudentGrade.service.GradeService;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> addGrade(@RequestBody Grade grade, @PathVariable Long studentId,
            @PathVariable Long courseId) {
        Grade createdGrade = gradeService.addGrade(grade, studentId, courseId);
        return new ResponseEntity<>(createdGrade, HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
        Grade grade = gradeService.getGrade(studentId, courseId);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @PutMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> updateGrade(@RequestBody Grade grade, @PathVariable Long studentId,
            @PathVariable Long courseId) {
        Grade updatedGrade = gradeService.updateGrade(grade, studentId, courseId);
        return new ResponseEntity<>(updatedGrade, HttpStatus.OK);
    }

    @DeleteMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteMapping(@PathVariable Long studentId, @PathVariable Long courseId) {
        gradeService.deleteGrade(studentId, courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getAllStudentGrades(@PathVariable Long studentId) {
        List<Grade> allStudentGrades = gradeService.getAllStudentGrades(studentId);
        return new ResponseEntity<>(allStudentGrades, HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Grade>> getAllCourseGrades(@PathVariable Long courseId) {
        List<Grade> allCourseGrades = gradeService.getAllCourseGrades(courseId);
        return new ResponseEntity<>(allCourseGrades, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> getAllGrades = gradeService.getAllGrades();
        return new ResponseEntity<>(getAllGrades, HttpStatus.OK);
    }

}
