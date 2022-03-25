package com.example.BlogComponent.Service;

import com.example.BlogComponent.Entity.Blog;
import com.example.BlogComponent.Exception.BlogDeletionException;
import com.example.BlogComponent.Exception.BlogInsertionException;

import java.util.List;


public interface BlogService {

    public Blog postBlog(Blog blog) throws BlogInsertionException;

    public Blog getBlogByBlogId(String blogId);

    public Blog updateBlog(Blog blog);

    public List<Blog> getAllBlogs();

    public String deleteBlogByBlogId(String blogId) throws BlogDeletionException;
}

