package org.javaroute.service.impl;

import org.javaroute.mapper.StudentMapper;
import org.javaroute.model.Student;
import org.javaroute.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(Integer id) {

        return studentMapper.getStudentById(id);
    }

    @Override
    public List<Student> getStudents() {
        return studentMapper.getStudents();
    }

    @Override
    @Transactional
    public void insertStudent(Student student) {
        studentMapper.insertStudent(student);
       int i=0;
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
           studentMapper.deleteStudentById(id);
    }
}
