package com.eclipseeio.emi.repository;


import com.eclipseeio.emi.model.CallDetail;
import com.eclipseeio.emi.model.CallTopic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CallDetailsRepository extends JpaRepository<CallDetail, Long> {

    CallDetail findById(Long id);

    Page<CallDetail> findAllByStatusIsTrue(Specification<CallDetail> specificationSpecification, Pageable pageable);

    Page<CallDetail> findAllByStatusIsTrue(Pageable pageable);


}
