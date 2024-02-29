package com.example.bookreview.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.bookreview.model.Author;
import com.example.bookreview.model.Book;
import com.example.bookreview.repository.AuthorRepo;
@Service
public class AuthorService {
    

    private AuthorRepo authorRepo;
   
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public Author getAuthorById(int authorId) {
        return authorRepo.findById(authorId).orElse(null);
    }

    public Author saveAuthor(Author author) {
        return authorRepo.save(author);
    }

    public void deleteAuthor(int authorId) {
        authorRepo.deleteById(authorId);
    }
    public Page<Author> authorpgn(int offset,int pagesize)
    {
        return authorRepo.findAll(PageRequest.of(offset,pagesize));
    }
    public List<Author> sortAuthor(String field)
    {
        return authorRepo.findAll( Sort.by(Sort.Direction.ASC,field)   );
    }
}