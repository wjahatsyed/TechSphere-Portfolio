package com.wjahatsyed.portfolio.ai_career_mobility_tool.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String department;
    private String skillSet;
}
