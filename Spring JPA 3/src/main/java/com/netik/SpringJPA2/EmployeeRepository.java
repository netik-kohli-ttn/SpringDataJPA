package com.netik.SpringJPA2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e.firstName, e.lastName from Employee e where e.salary > (select avg(e2.salary) from Employee e2) " +
            "order by e.age asc, e.salary desc")
    List<Object[]> getEmployeesAboveAverageSalary();

    @Modifying
    @Query("update Employee e set e.salary = :newSalary where e.salary < (select avg(e2.salary) from Employee e2)")
    void updateSalaryBelowAverage(@Param("newSalary") Double newSalary);

    @Modifying
    @Query("delete from Employee e where e.salary = (select min(e2.salary) from Employee e2)")
    void deleteEmployeesWithMinSalary();

    // Answer 2 (1) and (2)
    @Query(value = "select emp_id, emp_first_name, emp_age from employee_table where emp_last_name like '%singh'", nativeQuery = true)
    List<Object[]> findEmployeesWithLastNameSingh();

    @Modifying
    @Transactional
    @Query(value = "delete from employee_table where emp_age > :age", nativeQuery = true)
    void deleteEmployeesOlderThan(@Param("age") int age);
}
