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
import com.example.bookreview.model.Book;
import com.example.bookreview.service.BookService;
@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public Book saveBook(@RequestBody Book book) {
        return bookService.postBook(book);
    }
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int authorId) {
        return bookService.getbookid(authorId);
    }


    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int authorId) {
        bookService.delbook(authorId);
    }

    @GetMapping("/page/{offset}/{pagesize}")
    public Page<Book> pagebks(@PathVariable int offset,@PathVariable int pagesize)
    {
        return bookService.bookpgn(offset, pagesize);
    }
    @GetMapping("/sorting/{byfield}")
    public List<Book> sortbks(@PathVariable("byfield") String field)
    {
        return bookService.sortBooks(field);
    }    
    
}