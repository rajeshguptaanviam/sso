package com.eclipseeio.emi.repository;

import com.eclipseeio.emi.model.Benefits;
import com.eclipseeio.emi.model.States;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BenefitsRepository extends JpaRepository<Benefits, Long> {

	Benefits findById(Long sname);
	Benefits findByBenefitsName(String string);
	Benefits findByIdAndActive(Long id,Boolean staBoolean);
	List<Benefits> findAllByActive(Boolean status);


}
