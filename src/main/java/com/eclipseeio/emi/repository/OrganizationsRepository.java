package com.eclipseeio.emi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.Organizations;

import java.util.List;

public interface OrganizationsRepository extends JpaRepository<Organizations, Long> {
	
	Organizations findByOrganizationName(String oString);
	Organizations findById(Long id);
	Organizations findByIdAndActiveIsTrue(Long id);
	List<Organizations> findAllByActiveIsTrue();
}
