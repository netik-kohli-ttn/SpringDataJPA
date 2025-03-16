## Answer 10
@Transactional is an annotation in Spring Boot that provides automatic transaction management. It ensures that a method executes within a single transaction, meaning either all operations succeeded or rollback if any operation will fails. This prevents data inconsistency. If a method executes successfully, all database operations inside it are executed.
If an exception occurs, all operations are rolled back, preventing partial data updates.
