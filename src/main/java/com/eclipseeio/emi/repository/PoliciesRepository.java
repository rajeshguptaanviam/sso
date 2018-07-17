package com.eclipseeio.emi.repository;

import com.eclipseeio.emi.model.Policies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoliciesRepository extends JpaRepository<Policies, Long> {

    Policies findByPoliciesName(String policiesName);
    Policies findById(Long id);
    Policies findByIdAndActiveIsTrue(Long id);
    List<Policies> findAllByActiveIsTrue();



}


