package com.eclipseeio.emi.repository;

import com.eclipseeio.emi.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username);
    User findByEmail( String email);
    User findById(Long userId);

    Page<User> findAll(Specification<User> spec, Pageable pageable);
}

