package com.example.BlogComponent.Model;
import com.example.BlogComponent.Entity.Author;
import java.util.Objects;

public class CommentModel {
    private String commentId;
    private String text;
    private String blogId;
    public Author author;

    public CommentModel(String commentId, String text, String blogId, Author author) {
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
        if (!(o instanceof CommentModel)) return false;
        CommentModel that = (CommentModel) o;
        return commentId.equals(that.commentId) && text.equals(that.text) && blogId.equals(that.blogId) && author.equals(that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, text, blogId, author);
    }

    @Override
    public String toString() {
        return "CommentModel{" +
                "commentId='" + commentId + '\'' +
                ", text='" + text + '\'' +
                ", blogId='" + blogId + '\'' +
                ", author=" + author +
                '}';
    }
}
