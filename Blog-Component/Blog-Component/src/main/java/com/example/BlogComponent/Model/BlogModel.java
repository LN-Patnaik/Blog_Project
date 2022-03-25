package com.example.BlogComponent.Model;

import com.example.BlogComponent.Entity.Author;
import com.example.BlogComponent.Entity.Blog;
import com.example.BlogComponent.Entity.Comment;

import java.util.List;
import java.util.Objects;

public class BlogModel {
    public String blogId;
    public String title;
    public String dateOfPublish;
    public String content;
    public Author author;
    public List<Comment> comments;

    public BlogModel(String blogId, String title, String dateOfPublish, String content, Author author, List<Comment> comments) {
        this.blogId = blogId;
        this.title = title;
        this.dateOfPublish = dateOfPublish;
        this.content = content;
        this.author = author;
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlogModel)) return false;
        BlogModel blogModel = (BlogModel) o;
        return blogId.equals(blogModel.blogId) && title.equals(blogModel.title) && dateOfPublish.equals(blogModel.dateOfPublish) && content.equals(blogModel.content) && author.equals(blogModel.author) && comments.equals(blogModel.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blogId, title, dateOfPublish, content, author, comments);
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOfPublish() {
        return dateOfPublish;
    }

    public void setDateOfPublish(String dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "BlogModel{" +
                "blogId='" + blogId + '\'' +
                ", title='" + title + '\'' +
                ", dateOfPublish='" + dateOfPublish + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", comments=" + comments +
                '}';
    }
}
