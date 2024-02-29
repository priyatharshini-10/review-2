package com.example.bookreview.service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bookreview.model.Book;
import com.example.bookreview.repository.BookRepo;

@Service
public class BookService {
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public Book postBook(Book book)
    {
        return bookRepo.save(book);
    }
    public List<Book> getAll()
    {
        return bookRepo.findAll();
    }
    public Book getbookid(int authorId )
    {
        return bookRepo.findById(authorId).orElse(null);
    }
    public void delbook(int authorId)
    {
        bookRepo.deleteById(authorId);
    }
   public Page<Book> bookpgn(int offset,int pagesize)
    {
        return bookRepo.findAll(PageRequest.of(offset,pagesize));
    }
    public List<Book> sortBooks(String field)
    {
        return bookRepo.findAll( Sort.by(Sort.Direction.ASC,field)   );
    }
}
