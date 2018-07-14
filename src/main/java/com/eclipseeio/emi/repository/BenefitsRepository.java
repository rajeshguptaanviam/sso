package com.eclipseeio.emi.repository;

import com.eclipseeio.emi.model.Benefits;
import com.eclipseeio.emi.model.States;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenefitsRepository extends JpaRepository<Benefits, Long> {

	Benefits findById(Long sname);
	Benefits findByBenefitsName(String string);


}
