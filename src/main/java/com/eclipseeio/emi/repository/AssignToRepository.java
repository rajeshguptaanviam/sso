package com.eclipseeio.emi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.AssignTo;

public interface AssignToRepository extends JpaRepository<AssignTo, Long> {

	public AssignTo findByAssignName(String assignToName);

}
