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
    private CompanyResponse companyResponse;
    private Date createdAt;
    private Date updatedAt;


    public CompanyDepartmentResponse(CompanyDepartment companyDepartment) {
        this.id = companyDepartment.getId();
        this.companyDepartment = companyDepartment.getCompanyDepartmentName();
        this.companyResponse =CompanyResponeFactory.create(companyDepartment.getCompany());
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

    public CompanyResponse getCompanyResponse() {
        return companyResponse;
    }

    public void setCompanyResponse(CompanyResponse companyResponse) {
        this.companyResponse = companyResponse;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
