package com.wjahatsyed.portfolio.ai_career_mobility_tool.dto;

import lombok.Data;

@Data
public class RecommendationDto {
    private long id;
    private long employeeId;
    private long roleId;
    private String status;
}
