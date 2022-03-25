package com.example.BlogComponent.Service;

import com.example.BlogComponent.Entity.Blog;
import com.example.BlogComponent.Exception.BlogAlreadyExistsException;
import com.example.BlogComponent.Exception.BlogDeletionException;
import com.example.BlogComponent.Exception.BlogInsertionException;
import com.example.BlogComponent.Exception.BlogNotFoundException;
import com.example.BlogComponent.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
   private BlogRepository blogRepository;

    @Override
    public Blog postBlog(Blog blog) {
        Blog blog1;
        if(blogRepository.existsById(blog.getBlogId()))
        {
            throw new BlogAlreadyExistsException("Blog already exists");
        }
        try {
            blog1 = blogRepository.save(blog);
        }
        catch (BlogInsertionException e)
        {
            throw new BlogInsertionException("Blog insertion Exception");
        }
        return blog1;
    }

    @Override
    public Blog getBlogByBlogId(String blogId) {

       return blogRepository.findById(blogId)
               .orElseThrow(()->new BlogNotFoundException("Blog Not Found"));

    }

    @Override
    public Blog updateBlog(Blog blog) throws BlogInsertionException {
        Blog updatedBlog;
        try {
            updatedBlog  = blogRepository.save(blog);
           }
           catch (BlogInsertionException e)
           {
               throw new BlogInsertionException("Blog update failed");
           }
        return updatedBlog;
    }

    @Override
    public List<Blog> getAllBlogs() {
        List<Blog> blogs;
        try {
            blogs =blogRepository.findAll();
        }
        catch (BlogNotFoundException e)
        {
            throw new BlogNotFoundException("Blogs not found");
        }
        return blogs;
    }

    @Override
    public String deleteBlogByBlogId(String blogId) throws BlogDeletionException {

        try {
            if (!blogRepository.existsById(blogId)) {
                    throw new BlogDeletionException("Blog not found!");
            }
        }
        catch (BlogDeletionException e){
            throw e;
        }
        try {
            blogRepository.deleteById(blogId);
        }catch (Exception e){
            throw e;
        }
        return "Blog Deleted Successfully";
    }
}
