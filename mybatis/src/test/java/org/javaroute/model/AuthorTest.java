package org.javaroute.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    @Test
    public void toStringTest() {
        Author author=new Author();
        author.setId(1);
        author.setName("都是洞");
        author.setAge(23);
        System.out.println(author.toString());
    }
}