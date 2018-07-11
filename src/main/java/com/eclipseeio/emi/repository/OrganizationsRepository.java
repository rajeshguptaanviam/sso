package com.eclipseeio.emi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.Organizations;

public interface OrganizationsRepository extends JpaRepository<Organizations, Long> {
	
	public Organizations findByOrganizationName(String oString);
}
