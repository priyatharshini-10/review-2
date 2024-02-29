package com.example.bookreview.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookreview.model.Author;

public interface AuthorRepo extends JpaRepository <Author,Integer> {

    
}
