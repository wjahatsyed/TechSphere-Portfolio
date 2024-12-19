package com.wjahatsyed.portfolio.ai_career_mobility_tool.repository;

import com.wjahatsyed.portfolio.ai_career_mobility_tool.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Additional query methods if needed
}
