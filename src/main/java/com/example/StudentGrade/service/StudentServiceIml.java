package com.example.StudentGrade.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentGrade.entity.Course;
import com.example.StudentGrade.entity.Student;
import com.example.StudentGrade.exception.StudentNotFoundException;
import com.example.StudentGrade.repository.StudentRepository;

@Service
public class StudentServiceIml implements StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentServiceIml(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);

        if (student.isPresent()) {
            return student.get();
        } else {
            throw new StudentNotFoundException(studentId);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        // TODO Auto-generated method stub
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void updateStudent(Long studentId, Student student) {
        Optional<Student> updateStudent = studentRepository.findById(studentId);

        if (updateStudent.isPresent()) {

            Student unwrappedStudent = updateStudent.get();
            unwrappedStudent.setName(student.getName());
            unwrappedStudent.setDate(student.getDate());
            studentRepository.save(unwrappedStudent);
        } else {
            throw new StudentNotFoundException(studentId);
        }

    }

    @Override
    public Set<Course> getEnrolledCourses(Long studentId) {

        Student student = getStudent(studentId);

        return student.getCourses();
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

}
