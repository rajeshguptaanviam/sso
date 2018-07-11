package com.eclipseeio.emi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	public Company findByCompanyName(String name);

}
