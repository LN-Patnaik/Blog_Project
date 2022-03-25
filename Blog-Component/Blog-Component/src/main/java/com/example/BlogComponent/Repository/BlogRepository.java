package com.example.BlogComponent.Repository;
import com.example.BlogComponent.Entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog,String> {
}
