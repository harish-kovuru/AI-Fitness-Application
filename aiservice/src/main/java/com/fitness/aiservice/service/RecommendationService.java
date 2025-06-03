package com.fitness.aiservice.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fitness.aiservice.repository.RecommendationRepository;

import com.fitness.aiservice.model.Recommendation;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;

    public List<Recommendation> getUserRecommendation(String userId) {
      return recommendationRepository.findByUserId(userId);
    }

    public Recommendation  getActivityRecommendation(String activityId) {
       return recommendationRepository.findByActivityId(activityId)
       .orElseThrow(()-> new RuntimeErrorException(null, "No recommendation found" + activityId));
    }
}
