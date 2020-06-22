package org.javaroute.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.javaroute.model.Author;
import org.javaroute.util.SqlSessionFactoryUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorMapperTest {
   SqlSessionFactory sqlSessionFactory=null;

    @Before
    public void setUp() throws Exception {
            sqlSessionFactory= SqlSessionFactoryUtils.getInstance();
    }

    @Test
    public void testInsertAuthor() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Author author=new Author();
        author.setName("南派三叔");
        author.setAge(36);
        AuthorMapper mapper=sqlSession.getMapper(AuthorMapper.class);
        mapper.insertAuthor(author);
        sqlSession.commit();
    }
}