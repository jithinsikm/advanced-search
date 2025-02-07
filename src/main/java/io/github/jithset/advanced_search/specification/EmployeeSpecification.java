package io.github.jithset.advanced_search.specification;

import io.github.jithset.advanced_search.entities.Employee;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class EmployeeSpecification {
    public EmployeeSpecification() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<Employee> hasName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (StringUtils.hasText(name)) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
            }
            return null;
        };
    }

    public static Specification<Employee> hasAge(Integer age) {
        return (root, query, criteriaBuilder) -> {
            if (age != null) {
                return criteriaBuilder.equal(root.get("age"), age);
            }
            return null;
        };
    }

    public static Specification<Employee> hasSalaryGreaterThan(Double salary) {
        return (root, query, criteriaBuilder) -> {
            if (salary != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), salary);
            }
            return null;
        };
    }

    public static Specification<Employee> hasBonusGreaterThan(BigDecimal bonus) {
        return (root, query, criteriaBuilder) -> {
            if (bonus != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("bonus"), bonus);
            }
            return null;
        };
    }

    public static Specification<Employee> isActive(Boolean isActive) {
        return (root, query, criteriaBuilder) -> {
            if (isActive != null) {
                return criteriaBuilder.equal(root.get("isActive"), isActive);
            }
            return null;
        };
    }

    public static Specification<Employee> hasNameOrAge(String name, Integer age) {
        return (root, query, criteriaBuilder) -> {
            Predicate namePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
            Predicate agePredicate = criteriaBuilder.equal(root.get("age"), age);
            return criteriaBuilder.or(namePredicate, agePredicate);
        };
    }
}
