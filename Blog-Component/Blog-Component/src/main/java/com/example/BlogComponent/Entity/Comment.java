package com.example.BlogComponent.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Document
public class Comment {

    @Id
    private String commentId;

    @NotBlank(message = "comment must not be blank")
    @Pattern(regexp = "^((?!.*(donkey|monkey).*).)*$", message = "Bad Words are not allowed")
    private String text;

    @NotNull
    private String blogId;
    public Author author;

    public Comment(String commentId, String text, String blogId, Author author) {
        this.commentId = commentId;
        this.text = text;
        this.blogId = blogId;
        this.author = author;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return commentId.equals(comment.commentId) && text.equals(comment.text) && blogId.equals(comment.blogId) && author.equals(comment.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, text, blogId, author);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", text='" + text + '\'' +
                ", blogId='" + blogId + '\'' +
                ", author=" + author +
                '}';
    }
}
