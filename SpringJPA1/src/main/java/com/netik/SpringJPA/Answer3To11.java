package com.netik.SpringJPA;

import com.netik.SpringJPA.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class Answer3To11 {

    @Autowired
    private EmployeeService employeeService;

    // Answer 3
    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // Answer 4
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Answer 5
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " is deleted";
    }

    // Answer 6
    @GetMapping("/all")
    public List<Employee> getEmployeeById() {
        return employeeService.getAllEmployees();
    }

    // Answer 7
    @GetMapping("/count")
    public long getTotalEmployees() {
        return employeeService.getTotalEmployees();
    }

    // Answer 8
    @GetMapping("/pageAndSort")
    public Page<Employee> getEmployeesWithPaginationAndSorting(int page, int size) {
        return employeeService.getEmployeesWithPaginationAndSorting(page, size);
    }

    // Answer 9
    @GetMapping("/findByName")
    public Employee findByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }

    // Answer 10
    @GetMapping("/findByNameStartWith")
    public List<Employee> findByNameStartingWith(@RequestParam String starts) {
        return employeeService.findByNameStartingWith(starts);
    }

    // Answer 11
    @GetMapping("/ageBetween")
    public List<Employee> findByAgeBetween(
            @RequestParam int startAge,
            @RequestParam int endAge) {
        return employeeService.findByAgeBetween(startAge, endAge);
    }
}
