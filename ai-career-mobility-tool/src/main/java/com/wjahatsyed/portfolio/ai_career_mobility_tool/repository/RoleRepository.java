package com.wjahatsyed.portfolio.ai_career_mobility_tool.repository;

import com.wjahatsyed.portfolio.ai_career_mobility_tool.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Additional query methods if needed
}
