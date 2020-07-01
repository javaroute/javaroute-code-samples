package org.javaroute.controller;

import org.javaroute.model.Student;
import org.javaroute.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable("id") Integer id){
         Student student=studentService.getStudentById(id);
         return student;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public void insertStudent(@PathVariable("id") Integer id){
        Student student=new Student();
        student.setId(id);
        student.setAge(36);
        student.setName("赵小豪");
        studentService.insertStudent(student);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void updateStudent(@PathVariable("id") Integer id){
        Student student=new Student();
        student.setId(id);
        student.setAge(36);
        student.setName("赵小豪");
        studentService.updateStudent(student);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteStudentById(id);
    }
}
