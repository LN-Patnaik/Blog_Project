package com.example.BlogComponent.Repository;

import com.example.BlogComponent.Entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author,String> {

    public Author getAuthorByUsername(String username);

}
