package io.github.jithset.advanced_search.services;

import io.github.jithset.advanced_search.entities.Employee;
import io.github.jithset.advanced_search.repository.EmployeeRepository;
import io.github.jithset.advanced_search.specification.EmployeeSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> searchEmployees(String name, Integer age, Double salary, BigDecimal bonus, Boolean isActive, boolean useOr) {
        Specification<Employee> spec = Specification.where(null);

        // Add conditions dynamically
        if (name != null) {
            spec = spec.and(EmployeeSpecification.hasName(name));
        }
        if (age != null) {
            spec = spec.and(EmployeeSpecification.hasAge(age));
        }
        if (salary != null) {
            spec = spec.and(EmployeeSpecification.hasSalaryGreaterThan(salary));
        }
        if (bonus != null) {
            spec = spec.and(EmployeeSpecification.hasBonusGreaterThan(bonus));
        }
        if (isActive != null) {
            spec = spec.and(EmployeeSpecification.isActive(isActive));
        }

        // Apply OR condition if required
        if (useOr) {
            // OR between 'name' and 'age'
            spec = spec.or(EmployeeSpecification.hasNameOrAge(name, age));
        }

        return employeeRepository.findAll(spec);
    }
}
