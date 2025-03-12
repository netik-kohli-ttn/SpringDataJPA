package com.netik.SpringJPA.repository;

import com.netik.SpringJPA.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Answer 9
    Employee findByName(String name);

    // Answer 10
    List<Employee> findByNameStartingWith(String prefix);

    // Answer 11
    List<Employee> findByAgeBetween(int startAge, int endAge);
}
