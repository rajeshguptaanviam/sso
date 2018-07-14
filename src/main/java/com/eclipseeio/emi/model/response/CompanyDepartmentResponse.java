package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.CompanyDepartment;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDepartmentResponse implements Serializable {
    private Long id;
    private String companyDepartment;
    private Date createdAt;
    private Date updatedAt;


    public CompanyDepartmentResponse(CompanyDepartment companyDepartment) {
        this.id = companyDepartment.getId();
        this.companyDepartment = companyDepartment.getCompanyDepartmentName();
        this.createdAt = companyDepartment.getCreatedAt();
        this.updatedAt = companyDepartment.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyDepartment() {
        return companyDepartment;
    }

    public void setCompanyDepartment(String companyDepartment) {
        this.companyDepartment = companyDepartment;
    }
}
