package org.javaroute.mapper;

import org.javaroute.model.Author;

import java.util.List;

public interface AuthorMapper {
    Author getAuthorById(Integer id);
    List<Author> getAllAuthor();
    Integer insertAuthor(Author author);
    Integer updateAuthor(Author author);
    Integer deleteAuthorById(Integer id);
}
