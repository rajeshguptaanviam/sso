package com.eclipseeio.emi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository<Organizations> extends JpaRepository<Organizations, Long> {
}

