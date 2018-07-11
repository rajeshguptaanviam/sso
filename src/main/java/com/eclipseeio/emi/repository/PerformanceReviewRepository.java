package com.eclipseeio.emi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.PerformanceReview;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {

	PerformanceReview findByPerformanceReviewName(String performanceReviewName);

}
