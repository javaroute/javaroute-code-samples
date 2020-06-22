package org.javaroute.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.javaroute.model.Student;
import org.javaroute.util.SqlSessionFactoryUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StudentMapperTest {
    SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void setUp() throws Exception {
        sqlSessionFactory= SqlSessionFactoryUtils.getInstance();

    }
    @Test
    public void testSelect(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
        String id="e535195b-a7af-11ea-bbd5-0242ac110002";
        Student student=mapper.getStudentById(id);
        System.out.println(student.toString());
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
        List<Student> list=mapper.getStudents();
        for (Student student : list) {
            System.out.println(student.toString());
        }

    }

    @Test
    public void testSelectStudentsByPage() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int curPage=2;
        int pageSize=2;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("m",(curPage-1)*pageSize);
        map.put("n",pageSize);
        List<Student> list = mapper.getStudentsByPage(map);
        for (Student student : list) {
            System.out.println(student);
        }

    }

    @Test
    public void testInsert(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Student student=new Student();
        student.setName("赵小豪");
        student.setAge(28);
        StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
        int rows=mapper.insertStudent(student);
        System.out.println("rows = " + rows);
        sqlSession.commit();
    }

    @Test
    public void testUpdateStudent() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Student student=new Student();
        student.setId("e535195b-a7af-11ea-bbd5-0242ac110002");
        student.setName("赵小豪");
        student.setAge(29);
        StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
        int rows=mapper.updateStudent(student);
        System.out.println("rows = " + rows);
        sqlSession.commit();
    }

    @Test
    public void testDeleteStudent() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        String id="e535195b-a7af-11ea-bbd5-0242ac110002";
        StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
        int rows=mapper.deleteStudentById(id);
        System.out.println("rows = " + rows);
        sqlSession.commit();
    }
}
