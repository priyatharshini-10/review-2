package com.example.bookreview.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookreview.model.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {

    
}