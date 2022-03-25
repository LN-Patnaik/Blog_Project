package com.example.BlogComponent.Service;

import com.example.BlogComponent.Entity.Author;

public interface AuthorService {

    public Author addAuthor(Author author);

    public String deleteAuthorById(String authorId);

    public Author getAuthorByUsername(String username) throws Exception;
}
