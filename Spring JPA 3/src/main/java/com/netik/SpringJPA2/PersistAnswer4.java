package com.netik.SpringJPA3;

import jakarta.persistence.*;
import java.util.Arrays;

public class PersistAnswer4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("answer4");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Address address1 = new Address("1", "India", "Dehradun, Uttarakhand");
        Author author1 = new Author("Netik Kohli", address1, Arrays.asList("Java", "JPA", "Backend Development"));

        Address address2 = new Address("2", "India", "Noida, Uttar Pradesh");
        Author author2 = new Author("Saurabh Sharma", address2, Arrays.asList("Spring", "Spring boot", "MySQL"));

        em.persist(author1);
        em.persist(author2);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

