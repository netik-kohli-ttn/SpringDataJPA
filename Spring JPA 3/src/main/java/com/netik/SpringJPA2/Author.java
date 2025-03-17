package com.netik.SpringJPA3;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;  //Answer2

    @ElementCollection
    private List<String> subject;   //Answer3

    @OneToOne(cascade = CascadeType.ALL)   //Answer6
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToMany(cascade = CascadeType.ALL)    //Answer8
    @JoinTable(name = "author_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    public Author(String name, Address address, List<String> subject) {
        this.name = name;
        this.address = address;
        this.subject = subject;
    }
    public Author(String name, Address address, List<String> subject, List<Book> books) {
        this.name = name;
        this.address = address;
        this.subject = subject;
        this.books = books;
    }

}

