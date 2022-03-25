package com.example.BlogComponent.Controller;

import com.example.BlogComponent.Entity.Author;
import com.example.BlogComponent.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @Value("${list.bad.words}")
    List<String> badWords;

    @GetMapping("/prop")
    public List<String> getProp()
    {
        return badWords;
    }

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody @Valid Author author)
    {
        Author addedAuthor=authorService.addAuthor(author);
        return addedAuthor;
    }

    @GetMapping("/{username}")
    public Author getAuthorByUsername(@PathVariable String username) throws Exception {
        Author author=authorService.getAuthorByUsername(username);
        return author;
    }


}
