package com.example.BlogComponent.Service;

import com.example.BlogComponent.Entity.Comment;

public interface CommentService {

    public String addComment(Comment comment,String blogId);

    public String deleteComment( String blogId,String commentId) throws Exception;

}
