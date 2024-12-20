package com.wjahatsyed.portfolio.ai_career_mobility_tool.dto;

import lombok.Data;

@Data
public class RecommendationRequest {
    private long employeeId;
    private String targetSkills;
}
