package com.eclipseeio.emi.repository;


import com.eclipseeio.emi.model.Organizations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organizations, Long> {
}

