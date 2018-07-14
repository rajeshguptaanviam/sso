package com.eclipseeio.emi.repository;

import com.eclipseeio.emi.model.AdditionalRequirements;
import com.eclipseeio.emi.model.AssignTo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalRequirementsRepository extends JpaRepository<AdditionalRequirements, Long> {

	AdditionalRequirements findById(Long assignToName);
	AdditionalRequirements findByAdditionalRequirementsName(String name);

}
