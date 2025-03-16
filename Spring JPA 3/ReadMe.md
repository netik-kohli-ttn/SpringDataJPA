## Answer 10
@Transactional is an annotation in Spring Boot that provides automatic transaction management. It ensures that a method executes within a single transaction, meaning either all operations succeeded or rollback if any operation will fails. This prevents data inconsistency. If a method executes successfully, all database operations inside it are executed.
If an exception occurs, all operations are rolled back, preventing partial data updates.


    @Transactional
    public void saveAuthorAndBooks() {
        Book book1 = new Book("Spring Boot");
        Book book2 = new Book("JPA Course");
        
        Author author = new Author("Netik Kohli", List.of(book1, book2));
        authorRepository.save(author);
        
        System.out.println("Author and books saved");
    }

In above code from this exercise I use @Transaction on the method saveAuthorAndBook() - if no error occurs, the author and books are saved successfully and if an error occurs, the transaction rolls back, and no data is saved in the database.
