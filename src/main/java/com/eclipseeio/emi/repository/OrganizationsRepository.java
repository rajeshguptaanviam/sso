package com.eclipseeio.emi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.Organizations;

public interface OrganizationsRepository extends JpaRepository<Organizations, Long> {
	
	Organizations findByOrganizationName(String oString);
	Organizations findById(Long id);
}
