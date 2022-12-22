package com.example.StudentGrade.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentGrade.entity.Course;
import com.example.StudentGrade.entity.Grade;
import com.example.StudentGrade.entity.Student;
import com.example.StudentGrade.exception.CourseNotFoundException;
import com.example.StudentGrade.exception.EnrolledNotFoundException;
import com.example.StudentGrade.exception.GradeNotFoundException;
import com.example.StudentGrade.exception.StudentNotFoundException;
import com.example.StudentGrade.repository.CourseRepository;
import com.example.StudentGrade.repository.GradeRepository;
import com.example.StudentGrade.repository.StudentRepository;

@Service
public class GradeServiceIml implements GradeService {

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Grade addGrade(Grade grade, Long studentId, Long courseId) {
        Course course = checkCourse(courseRepository.findById(courseId), courseId);
        Student student = checkStudent(studentRepository.findById(studentId), studentId);

        if (student.getCourses().contains(course) == false) {
            throw new EnrolledNotFoundException(studentId, courseId);
        }

        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);

    }

    public Course checkCourse(Optional<Course> entity, Long courseId) {

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new CourseNotFoundException(courseId);
        }
    }

    public Student checkStudent(Optional<Student> entity, Long studentId) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new StudentNotFoundException(studentId);
        }
    }

    @Override
    public Grade getGrade(Long studentId, Long courseId) {

        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);

        if (grade.isPresent()) {
            return grade.get();
        } else {
            throw new GradeNotFoundException(studentId, courseId);
        }
    }

    @Override
    public Grade updateGrade(Grade grade, Long studentId, Long courseId) {
        Optional<Grade> updatedGrade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);

        if (updatedGrade.isPresent()) {
            Grade unwrappedGrade = updatedGrade.get();
            unwrappedGrade.setScore(grade.getScore());
            return gradeRepository.save(unwrappedGrade);
        } else {
            throw new GradeNotFoundException(studentId, courseId);
        }

    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getAllStudentGrades(Long studentId) {

        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getAllCourseGrades(Long courseId) {

        return gradeRepository.findByCourseId(courseId);

    }

    @Override
    public List<Grade> getAllGrades() {
        // TODO Auto-generated method stub
        return (List<Grade>) gradeRepository.findAll();
    }

}
