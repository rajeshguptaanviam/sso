package com.eclipseeio.emi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.AssignTo;
import com.eclipseeio.emi.model.Industry;

public interface IndustryRepository extends JpaRepository<Industry, Long> {

	public Industry findByIndustryName(String industryName);
	

}
