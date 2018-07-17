package com.eclipseeio.emi.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.Company;


public interface CompanyRepository extends JpaRepository<Company, Long> {

	Company findByCompanyName(String name);
	Company findById(Long id);
	Page<Company> findAll(Specification<Company> specification, Pageable pageable);
	Page<Company> findAllByStatusIsTrue(Specification<Company> specification, Pageable pageable);
	Page<Company> findAllByStatusIsTrue(Pageable pageable);



}
