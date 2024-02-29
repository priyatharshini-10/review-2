package com.example.bookreview.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    private int bookId;
    private String bookName;
    @ManyToOne (cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="au_id")
    private Author author;

}