package com.netik.SpringJPA.service;

import com.netik.SpringJPA.Employee;
import com.netik.SpringJPA.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee newEmployee) {
            return employeeRepository.save(newEmployee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public long getTotalEmployees() {
        return employeeRepository.count();
    }

    public Page<Employee> getEmployeesWithPaginationAndSorting(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "age"));
        return employeeRepository.findAll(pageable);
    }

    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> findByNameStartingWith(String prefix) {
        return employeeRepository.findByNameStartingWith(prefix);
    }

    public List<Employee> findByAgeBetween(int startAge, int endAge) {
        return employeeRepository.findByAgeBetween(startAge, endAge);
    }
}
