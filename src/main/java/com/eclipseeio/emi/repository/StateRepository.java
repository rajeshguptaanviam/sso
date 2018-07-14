package com.eclipseeio.emi.repository;

import com.eclipseeio.emi.model.Industry;
import com.eclipseeio.emi.model.States;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<States, Long> {

	States findByStateName(String sname);

	States findById(Long id);


}
