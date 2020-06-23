package org.javaroute.mapper;

import org.javaroute.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    Student getStudentById(String id);
    List<Student> searchStudent(Map map);
    List<Student> getStudents();
    List<Student> getStudentsByPage(Map map);
    Integer insertStudent(Student student);
    Integer updateStudent(Student student);
    Integer deleteStudentById(String id);
}
