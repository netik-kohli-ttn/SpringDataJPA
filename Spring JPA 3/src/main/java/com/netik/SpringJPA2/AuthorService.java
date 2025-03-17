package com.netik.SpringJPA3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void saveAuthors() {
        Address address1 = new Address("1", "India", "Dehradun");
        Address address2 = new Address("3", "India", "Noida");

        List<Book> books1 = Arrays.asList(new Book("Spring and Spring Boot"), new Book("Hibernate Book"));
        List<Book> books2 = Arrays.asList(new Book("Java 8 and beyond"), new Book("JPA full course"));

        Author author1 = new Author("Netik Kohli", address1, Arrays.asList("Java", "JPA", "Backend Development"), books1);
        Author author2 = new Author("Suraj Kumar", address2, Arrays.asList("Spring", "Spring boot", "MySQL"), books2);

        authorRepository.save(author1);
        authorRepository.save(author2);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}

