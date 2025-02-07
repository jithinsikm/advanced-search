package io.github.jithset.advanced_search.controller;

import io.github.jithset.advanced_search.entities.Employee;
import io.github.jithset.advanced_search.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;


    @PostMapping()
    public Employee save(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping()
    public List<Employee> get() {
        return employeeService.findAll();
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Double salary,
            @RequestParam(required = false) BigDecimal bonus,
            @RequestParam(required = false) Boolean isActive, @RequestParam(defaultValue = "false") boolean useOr) {
        return employeeService.searchEmployees(name, age, salary, bonus, isActive, useOr);
    }
}
