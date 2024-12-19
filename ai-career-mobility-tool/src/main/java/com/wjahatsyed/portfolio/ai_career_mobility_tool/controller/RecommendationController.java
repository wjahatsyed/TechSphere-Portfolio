package com.wjahatsyed.portfolio.ai_career_mobility_tool.controller;

import com.wjahatsyed.portfolio.ai_career_mobility_tool.dto.RecommendationDto;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.dto.RecommendationRequest;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.dto.RecommendationStatusDto;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/career-mobility/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateRecommendations(@RequestBody RecommendationRequest recommendationRequest) {
        List<RecommendationDto> recommendations = recommendationService.generateRecommendations(recommendationRequest);
        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<RecommendationDto>> getRecommendations(@PathVariable long employeeId) {
        return ResponseEntity.ok(recommendationService.getRecommendations(employeeId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecommendationStatus(@PathVariable long id, @RequestBody RecommendationStatusDto statusDto) {
        recommendationService.updateRecommendationStatus(id, statusDto);
        return ResponseEntity.ok("Recommendation status updated successfully.");
    }
}
