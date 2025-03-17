package com.netik.SpringJPA3;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, Author author) {
        this.bookName = bookName;
        this.author = author;
    }

}

