package com.example.BlogComponent.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Document
public class Author {

     @Id
     @NotNull
     @Pattern(regexp = "^[0-9]{6}$", message = "Author Id must be of 6 characters")
     public String authorId;

     @NotNull(message = "firstName is required")
     @Size(min=2, max=15,message = "firstName length must be of 2 to 15 characters" )
     public String firstName;

     @NotNull(message = "lastName is required")
     @Size(min=2, max=15,message = "lastName length must be of 2 to 15 characters")
     public String lastName;

     @NotNull(message = "Email address is required")
     @Pattern(regexp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$",message="Invalid Email address")
     public String email;

     @NotNull(message = "Phone number is required")
     @Pattern(regexp = "^[0-9]{10}$", message = "Invalid Phone Number:Phone number must be of 10 digits")
     public String phoneNum;

     @NotNull(message = "username is required")
     public String username;

     @NotNull(message = "Password is required")
     @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$",message = "Invalid Password:Minimum eight and maximum 16 characters, at least one uppercase letter, one lowercase letter, one number and one special character")
     public String password;

    public Author(String authorId, String firstName, String lastName, String email, String phoneNum, String username, String password) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.username = username;
        this.password = password;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return authorId.equals(author.authorId) && firstName.equals(author.firstName) && lastName.equals(author.lastName) && email.equals(author.email) && phoneNum.equals(author.phoneNum) && username.equals(author.username) && password.equals(author.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, firstName, lastName, email, phoneNum, username, password);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId='" + authorId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
