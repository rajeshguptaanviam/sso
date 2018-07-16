package com.eclipseeio.emi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eclipseeio.emi.model.AssignTo;

import java.util.List;

public interface AssignToRepository extends JpaRepository<AssignTo, Long> {

	AssignTo findByAssignName(String assignToName);
	AssignTo findById(Long assignToName);
	AssignTo findByIdAndActiveIsTrue(Long id);
	List<AssignTo> findAllByActiveIsTrue();

}
