package com.example.BlogComponent.Controller;

import com.example.BlogComponent.Entity.Blog;
import com.example.BlogComponent.Exception.BlogDeletionException;
import com.example.BlogComponent.Exception.BlogInsertionException;
import com.example.BlogComponent.Service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
   private BlogService blogService;

    @PostMapping("/postBlog")
    @Operation(summary = "This is to add Blogs")
    public Blog postBlog(@RequestBody Blog blog) {
        Blog blog1=blogService.postBlog(blog);
        return blog1;
    }

    @GetMapping("/{blogId}")
    @Operation(summary = "This is to find blogs by Blog Id")
    public Blog getBlogByBlogId(@PathVariable String blogId)
    {
        Blog getBlog=blogService.getBlogByBlogId(blogId);
        return getBlog;
    }

    @PutMapping("/updateBlog")
    @Operation(summary = "This is to update blog")
    public Blog updateBlog(Blog blog)
    {
        Blog updatedBlog=blogService.updateBlog(blog);
        return updatedBlog;
    }

    @GetMapping("/blogs")
    @Operation(summary = "This is to get all Blogs")
    public List<Blog> getALlBlogs()
    {
        List<Blog> blogs=blogService.getAllBlogs();
        return blogs;
    }

    @DeleteMapping("/delete/{blogId}")
    public String deleteBlogById(@PathVariable String blogId) throws BlogDeletionException
    {
        return blogService.deleteBlogByBlogId(blogId);
    }
}
