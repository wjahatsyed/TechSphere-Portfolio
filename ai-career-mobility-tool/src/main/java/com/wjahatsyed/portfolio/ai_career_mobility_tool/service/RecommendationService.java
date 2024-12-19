package com.wjahatsyed.portfolio.ai_career_mobility_tool.service;

import com.wjahatsyed.portfolio.ai_career_mobility_tool.dto.RecommendationDto;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.dto.RecommendationRequest;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.dto.RecommendationStatusDto;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.model.Recommendation;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    public List<RecommendationDto> generateRecommendations(RecommendationRequest recommendationRequest) {
        // Mocked recommendation logic for now
        return recommendationRepository.findByEmployeeId(recommendationRequest.getEmployeeId())
                .stream()
                .map(rec -> {
                    RecommendationDto dto = new RecommendationDto();
                    dto.setId(rec.getId());
                    dto.setEmployeeId(rec.getEmployee().getId());
                    dto.setRoleId(rec.getRole().getId());
                    dto.setStatus(rec.getStatus());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<RecommendationDto> getRecommendations(long employeeId) {
        return recommendationRepository.findByEmployeeId(employeeId).stream()
                .map(rec -> {
                    RecommendationDto dto = new RecommendationDto();
                    dto.setId(rec.getId());
                    dto.setEmployeeId(rec.getEmployee().getId());
                    dto.setRoleId(rec.getRole().getId());
                    dto.setStatus(rec.getStatus());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public void updateRecommendationStatus(long id, RecommendationStatusDto statusDto) {
        Recommendation recommendation = recommendationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recommendation not found"));
        recommendation.setStatus(statusDto.getStatus());
        recommendationRepository.save(recommendation);
    }
}
