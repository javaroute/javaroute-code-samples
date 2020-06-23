package org.javaroute.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.javaroute.model.Author;
import org.javaroute.util.SqlSessionFactoryUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorMapperTest {
    SqlSessionFactory sqlSessionFactory=null;
    SqlSession sqlSession=null;

    @Before
    public void setUp() throws Exception {
            sqlSessionFactory= SqlSessionFactoryUtils.getInstance();
            sqlSession=sqlSessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
           if(sqlSession!=null){
               sqlSession.close();
           }
           if(sqlSessionFactory!=null){
              sqlSessionFactory=null;
           }
    }

    @Test
    public void testInsertAuthor() {

        Author author=new Author();
        author.setName("唐家三少");
        author.setAge(36);
        AuthorMapper mapper=sqlSession.getMapper(AuthorMapper.class);
        mapper.insertAuthor(author);
        sqlSession.commit();
    }
}