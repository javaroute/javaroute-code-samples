package org.javaroute.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.javaroute.model.User;
import org.javaroute.util.SqlSessionFactoryUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void testSelect(){
        //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getInstance();
        //获取sqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user= mapper.getUserById(1);
        System.out.println(user.toString());
        //关闭
        sqlSession.close();
    }
    @Test
    public void testSelectAll(){
        //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getInstance();
        //获取sqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行
        List<User> list=sqlSession.selectList("org.javaroute.mapper.UserMapper.getUsers");
        for (User user : list) {
            System.out.println(user.toString());
        }
        //关闭
        sqlSession.close();
    }
    @Test
    public void testSelectByPage(){
        //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getInstance();
        //获取sqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行
        //select * from student limit(curPage-1)*pageSize,pageSize;
        int curPage=3;
        int pageSize=10;
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("m",(curPage-1)*pageSize);
        map.put("n",pageSize);
        List<User> list=sqlSession.selectList("org.javaroute.mapper.UserMapper.getUsersByPage",map);
        for (User user : list) {
            System.out.println(user.toString());
        }
        //关闭
        sqlSession.close();
    }
    @Test
    public void testInsert(){
        SqlSessionFactory sqlSessionFactory=SqlSessionFactoryUtils.getInstance();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=new User();
        user.setUsername("小亮");
        user.setPassword("12311");
        int rows=sqlSession.insert("org.javaroute.mapper.UserMapper.insertUser",user);
        System.out.println("rows = " + rows);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUpdate(){
        SqlSessionFactory sqlSessionFactory=SqlSessionFactoryUtils.getInstance();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=new User();
        user.setId(3);
        user.setUsername("小亮");
        user.setPassword("123");
        int rows=sqlSession.update("org.javaroute.mapper.UserMapper.updateUser",user);
        System.out.println("rows = " + rows);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDelete(){
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getInstance();
        SqlSession sqlSession=sqlSessionFactory.openSession();

        int rows=sqlSession.delete("org.javaroute.mapper.UserMapper.deleteUserById",3);
        System.out.println("rows = " + rows);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}

