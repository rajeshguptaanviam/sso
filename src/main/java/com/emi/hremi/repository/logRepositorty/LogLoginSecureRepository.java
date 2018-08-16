package com.emi.hremi.repository.logRepositorty;

import com.emi.hremi.model.log.LogLoginSecureInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogLoginSecureRepository extends JpaRepository<LogLoginSecureInfo,Long> {

}
