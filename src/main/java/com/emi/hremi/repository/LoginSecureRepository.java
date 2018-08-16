package com.emi.hremi.repository;

import com.emi.hremi.model.LoginSecureInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginSecureRepository extends JpaRepository<LoginSecureInfo,Long> {

    LoginSecureInfo findByEmail(String email);
    LoginSecureInfo findByUsername(String username);
    LoginSecureInfo findByCompanyName(String companyName);


}
