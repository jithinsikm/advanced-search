package io.github.jithset.advanced_search.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tbl_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    private Integer age;

    private Double salary;

    @Column(precision = 10, scale = 2)
    private BigDecimal bonus;

    private Boolean isActive;

    private LocalDateTime createdDate=LocalDateTime.now();

}
