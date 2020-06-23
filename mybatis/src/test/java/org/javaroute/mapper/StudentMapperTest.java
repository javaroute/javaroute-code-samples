package org.javaroute.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.javaroute.model.Student;
import org.javaroute.util.SqlSessionFactoryUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        String id="8206e689-a7bc-11ea-bbd5-0242ac110002";
        Student student=mapper.getStudentById(id);
        Student student2=mapper.getStudentById(id);
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
        student.setId("8206e689-a7bc-11ea-bbd5-0242ac110002");
        student.setName("");
        student.setAge(45);
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

    @Test
    public void testSearchStudent() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String,String> map=new HashMap<String,String>();
        map.put("name","豪");
        map.put("age",null);
        List<Student> students = mapper.searchStudent(map);
        System.out.println(students.toString());
    }

    @Test
    public void testInsertStudentBatch() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students=new ArrayList<Student>();
        for (int i = 4; i <6 ; i++) {
            Student student=new Student();
            student.setId("9999"+i);
            student.setName("i"+i);
            student.setAge(30+i);
            students.add(student);
        }
        Integer row = mapper.insertStudentBatch(students);
        System.out.println("row = " + row);
        sqlSession.commit();

    }

    @Test
    public void getStudentsByIds() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Integer[] ids =new Integer[3];
        ids[0]=99990;
        ids[1]=99991;
        ids[2]=99992;
        List<Student> students = mapper.getStudentsByIds(ids);
        System.out.println(students);

    }
}

