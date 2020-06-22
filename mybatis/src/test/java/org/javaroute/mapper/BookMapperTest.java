package org.javaroute.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.javaroute.model.Book;
import org.javaroute.util.SqlSessionFactoryUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookMapperTest {
    SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void setUp() throws Exception {
        sqlSessionFactory= SqlSessionFactoryUtils.getInstance();
    }

    @Test
    public void testGetBookById() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        Integer id=1;
        Book book=mapper.getBookById(id);
        System.out.println("book= " + book.toString());
    }
}