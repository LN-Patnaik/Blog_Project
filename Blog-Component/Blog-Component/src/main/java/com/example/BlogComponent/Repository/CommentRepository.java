package com.example.BlogComponent.Repository;

import com.example.BlogComponent.Entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
}
