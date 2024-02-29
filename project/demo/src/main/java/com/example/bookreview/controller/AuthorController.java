package com.example.bookreview.controller;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookreview.model.Author;
import com.example.bookreview.model.Book;
import com.example.bookreview.service.AuthorService;
@RestController
@RequestMapping("/author")
public class AuthorController {
   
    private AuthorService authorService;
    

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping("/author")
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }
    @GetMapping("/getauthors")
    public List<Author> getAllAuthors() {

        return authorService.getAllAuthors();
    }

    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable int authorId) {
        return authorService.getAuthorById(authorId);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable int authorId) {
        authorService.deleteAuthor(authorId);
    }
     @GetMapping("/page/{offset}/{pagesize}")
    public Page<Author> pagebks(@PathVariable int offset,@PathVariable int pagesize)
    {
        return authorService.authorpgn(offset, pagesize);
    }
    @GetMapping("/sorting/{byfield}")
    public List<Author> sortbks(@PathVariable("byfield") String field)
    {
        return authorService.sortAuthor(field);
    }    
}