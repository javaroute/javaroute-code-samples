package org.javaroute.mapper;

import org.javaroute.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    Student getStudentById(String id);
    List<Student> getStudents();
    List<Student> getStudentsByPage(Map map);
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudentById(String id);
}
