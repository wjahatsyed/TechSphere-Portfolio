package com.wjahatsyed.portfolio.ai_career_mobility_tool.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Role role;

    private String status;
}
