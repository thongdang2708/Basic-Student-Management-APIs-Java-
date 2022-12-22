package com.example.StudentGrade.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentGrade.entity.Course;
import com.example.StudentGrade.entity.Student;
import com.example.StudentGrade.exception.CourseNotFoundException;
import com.example.StudentGrade.exception.StudentNotFoundException;
import com.example.StudentGrade.repository.CourseRepository;
import com.example.StudentGrade.repository.StudentRepository;

@Service
public class CourseServiceIml implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);

        if (course.isPresent()) {
            return course.get();
        } else {
            throw new CourseNotFoundException(id);
        }
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        Optional<Course> updatedCourse = courseRepository.findById(id);

        if (updatedCourse.isPresent()) {
            Course unwrappedCourse = updatedCourse.get();
            unwrappedCourse.setSubject(course.getSubject());
            unwrappedCourse.setCode(course.getCode());
            unwrappedCourse.setDescription(course.getDescription());
            return courseRepository.save(unwrappedCourse);
        } else {
            throw new CourseNotFoundException(id);
        }
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course addStudentToCourse(Long courseId, Long studentId) {
        Course course = getCourse(courseId);

        Optional<Student> student = studentRepository.findById(studentId);

        if (student.isPresent()) {
            Student unwrappedStudent = student.get();
            course.getStudents().add(unwrappedStudent);
            return courseRepository.save(course);
        } else {
            throw new StudentNotFoundException(studentId);
        }
    }

    @Override
    public Set<Student> getEnrolledStudents(Long courseId) {
        Course course = getCourse(courseId);
        return course.getStudents();
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }
}
