package com.eclipseeio.emi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.AssignTo;
import com.eclipseeio.emi.model.Industry;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IndustryRepository extends JpaRepository<Industry, Long> {

	Industry findByIndustryName(String industryName);

	Industry findByIdAndActive(Long id,boolean active);

	List<Industry> findAllByActive(boolean active);


}
