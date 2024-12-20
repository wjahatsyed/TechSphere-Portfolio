package com.wjahatsyed.portfolio.ai_career_mobility_tool.repository;

import com.wjahatsyed.portfolio.ai_career_mobility_tool.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findByEmployeeId(long employeeId);
}
