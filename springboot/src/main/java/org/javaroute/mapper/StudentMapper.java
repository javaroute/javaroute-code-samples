package org.javaroute.mapper;

import org.javaroute.model.Student;

import java.util.List;

public interface StudentMapper {

    Student getStudentById(Integer id);
    List<Student> getStudents();
    Integer insertStudent(Student student);
    Integer updateStudent(Student student);
    Integer deleteStudentById(Integer id);


}
