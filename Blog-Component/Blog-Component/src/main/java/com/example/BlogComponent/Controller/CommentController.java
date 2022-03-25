package com.example.BlogComponent.Controller;

import com.example.BlogComponent.Entity.Comment;
import com.example.BlogComponent.Service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/{blogId}/addComment/")
    @Operation(summary = "This is to add an comment")
    public String addComment(@RequestParam String text,@RequestBody Comment comment,@PathVariable  String blogId)
    {
        return commentService.addComment(comment,blogId);
    }

    @DeleteMapping("/{blogId}/{commentId}/deleteComment")
    @Operation(summary = "This is to delete comment")
    public String deleteComment(@PathVariable String blogId,@PathVariable String commentId) throws Exception {
        return commentService.deleteComment(blogId,commentId);
    }

}
