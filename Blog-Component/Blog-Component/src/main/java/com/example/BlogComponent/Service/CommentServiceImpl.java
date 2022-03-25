package com.example.BlogComponent.Service;

import com.example.BlogComponent.Entity.Blog;
import com.example.BlogComponent.Entity.Comment;
import com.example.BlogComponent.Exception.BlogNotFoundException;
import com.example.BlogComponent.Exception.CommentNotFoundException;
import com.example.BlogComponent.Repository.BlogRepository;
import com.example.BlogComponent.Repository.CommentRepository;
import com.example.BlogComponent.Utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    ValidationUtils validationUtils;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BlogService blogService;


    @Override
    public String addComment(Comment comment, String BlogId) {
        //get blog by blogId
        Blog blog=blogService.getBlogByBlogId(BlogId);
        //set blogId to the new comment object
        comment.setBlogId(blog.getBlogId());
        //get comments list from the existing blog
        List<Comment> comments= blog.getComments();
        //add new comment to the comments list
        comments.add(comment);
        //set comments List to the comments list of existing blog
        blog.setComments(comments);
            try {
                blogRepository.save(blog);
                commentRepository.save(comment);
            } catch (Exception e) {
                throw e;
        }
        return "Comment added";
    }


    @Override
    public String deleteComment(String blogId,String commentId) throws Exception {
        try {
            Blog blog = blogService.getBlogByBlogId(blogId);
            Optional<Comment> comment1;
            comment1  = commentRepository.findById(commentId);
            if (comment1.isPresent())
            {
                if (blog.getComments().contains(comment1.get()))
                {
                    List<Comment> commentList = blog.getComments();
                    commentList.remove(comment1.get());
                    blog.setComments(commentList);
                    blogRepository.save(blog);
                    return "Deleted Successfully";
                }
                else
                {
                    return "Comment not present in blog";
                }
            }
            else
            {
                return "Comment not found";
            }
        }catch (BlogNotFoundException e){
            throw new BlogNotFoundException("Blog not Found");
        }catch (CommentNotFoundException e){
            throw new CommentNotFoundException("Comment not found");
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }
}
