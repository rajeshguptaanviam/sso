package com.eclipseeio.emi.repository;


import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.CompanyDepartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompanyDepartmentRepository extends JpaRepository<CompanyDepartment, Long> {

	CompanyDepartment findByCompanyDepartmentName(String name);
	CompanyDepartment findById(Long id);
	/*Page<CompanyDepartment> findAll(Specification<Company> specification, Pageable pageable);*/
	CompanyDepartment findByIdAndStatusIsTrue(Long id);
	List<CompanyDepartment> findAllByStatusIsTrue();


}
