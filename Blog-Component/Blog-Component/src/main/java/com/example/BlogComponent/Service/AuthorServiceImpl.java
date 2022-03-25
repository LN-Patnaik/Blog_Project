package com.example.BlogComponent.Service;
import com.example.BlogComponent.Entity.Author;
import com.example.BlogComponent.Exception.AuthorAlreadyExistsException;
import com.example.BlogComponent.Exception.AuthorNotFoundException;
import com.example.BlogComponent.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author addAuthor(Author author)
    {
        Author addedAuthor;
        if(authorRepository.existsById(author.getAuthorId()))
        {
            throw new AuthorAlreadyExistsException("Author already exists");
        }
        try {
            addedAuthor= authorRepository.save(author);
        }
        catch (Exception e)
        {
            throw e;
        }
      return addedAuthor;
    }

    public String deleteAuthorById(String authorId)
    {
        if(!authorRepository.existsById(authorId))
        {
            throw new AuthorNotFoundException("Author not found");
        }
        try {
            authorRepository.deleteById(authorId);
        }
        catch (Exception e)
        {
            throw e;
        }

        return "Author deleted successfully";
    }

    public Author getAuthorByUsername(String username) throws Exception {
        Author author;
        try {
             author = authorRepository.getAuthorByUsername(username);
             if(!Objects.nonNull(author))
             {
                 throw new AuthorNotFoundException("Author not found");
             }
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        return author;
    }
}
