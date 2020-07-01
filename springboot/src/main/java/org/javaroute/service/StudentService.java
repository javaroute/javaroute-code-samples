package org.javaroute.service;

import org.javaroute.model.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(Integer id);
    List<Student> getStudents();
    void insertStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(Integer id);
}
