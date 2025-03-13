package com.netik.SpringJPA2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringJpa2ApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testAnswer1() {
        Employee emp1 = new Employee();
        emp1.setFirstName("Netik");
        emp1.setLastName("Kohli");
        emp1.setSalary(1800000.0);
        emp1.setAge(23);

        Employee emp2 = new Employee();
        emp2.setFirstName("Sumit");
        emp2.setLastName("Gupta");
        emp2.setSalary(500000.0);
        emp2.setAge(32);
        employeeRepository.save(emp1);
        employeeRepository.save(emp2);

        List<Object[]> results = employeeRepository.getEmployeesAboveAverageSalary();
        for (Object[] row : results) {
            System.out.println("First Name: " + row[0] + ", Last Name: " + row[1]);
        }
    }

}
