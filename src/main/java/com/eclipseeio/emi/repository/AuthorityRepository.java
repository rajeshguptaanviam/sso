package com.eclipseeio.emi.repository;


import com.eclipseeio.emi.model.Authority;
import com.eclipseeio.emi.model.UserRoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findFirstByName(UserRoleName name);
}
