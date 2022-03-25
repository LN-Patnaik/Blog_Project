package com.example.BlogComponent.Entity;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
@NoArgsConstructor
public class Blog {

    @Id
    public String blogId;
    public String title;
    public String dateOfPublish;
    public String content;
    public Author author;
    public List<Comment> comments;

    public Blog(String blogId, String title, String dateOfPublish, String content, Author author, List<Comment> comments) {
        this.blogId = blogId;
        this.title = title;
        this.dateOfPublish = dateOfPublish;
        this.content = content;
        this.author = author;
        this.comments = comments;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blog)) return false;
        Blog blog = (Blog) o;
        return getBlogId().equals(blog.getBlogId()) && getTitle().equals(blog.getTitle()) && getDateOfPublish().equals(blog.getDateOfPublish()) && getContent().equals(blog.getContent()) && getAuthor().equals(blog.getAuthor()) && getComments().equals(blog.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBlogId(), getTitle(), getDateOfPublish(), getContent(), getAuthor(), getComments());
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId='" + blogId + '\'' +
                ", title='" + title + '\'' +
                ", dateOfPublish='" + dateOfPublish + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", comments=" + comments +
                '}';
    }
}
