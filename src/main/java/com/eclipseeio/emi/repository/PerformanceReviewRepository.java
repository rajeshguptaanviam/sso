package com.eclipseeio.emi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.PerformanceReview;

import java.util.List;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {

	PerformanceReview findByPerformanceReviewName(String performanceReviewName);
	PerformanceReview findById(Long id);
	PerformanceReview findByIdAndActiveIsTrue(Long id);
	List<PerformanceReview> findAllByActiveIsTrue();


}
