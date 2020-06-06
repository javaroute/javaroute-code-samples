package org.javaroute;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.javaroute.model.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();
        User user = (User) sqlSession.selectOne("org.javaroute.mapper.UserMapper.getUserById", 1);
        System.out.println(user);
        sqlSession.close();
    }

}