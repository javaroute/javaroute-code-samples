package org.javaroute.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaroute.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    Student getStudentById(String id);
    List<Student> getStudentsByIds(@Param("ids") Integer [] ids);
    List<Student> searchStudent(Map map);
    List<Student> getStudents();
    List<Student> getStudentsByPage(Map map);
    Integer insertStudent(Student student);
    Integer insertStudentBatch(@Param("students") List<Student> students);
    Integer updateStudent(Student student);
    Integer deleteStudentById(String id);
}
