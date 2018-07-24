package com.eclipseeio.emi.repository;


import com.eclipseeio.emi.model.CallTopic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CallTopicRepository extends JpaRepository<CallTopic, Long> {

    CallTopic findByCallTopicName(String callTopicName);
    CallTopic findById(Long id);
    List<CallTopic> findAllByActiveIsTrue();
    CallTopic findByIdAndActiveIsTrue(Long id);



}
