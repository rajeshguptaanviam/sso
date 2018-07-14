package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.AdditionalRequirements;
import com.eclipseeio.emi.model.Company;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalRequementResponse implements Serializable {

    private Long id;
    private String additionalRequirementsName;
    private Date createdAt;
    private CompanyResponse company;
    private Date updatedAt;

    public AdditionalRequementResponse(AdditionalRequirements additionalRequirements) {
        this.id = additionalRequirements.getId();
        this.additionalRequirementsName = additionalRequirements.getAdditionalRequirementsName();
        this.createdAt = additionalRequirements.getCreatedAt();
        this.company = CompanyResponeFactory.create(additionalRequirements.getCompany());
        this.updatedAt = additionalRequirements.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdditionalRequirementsName() {
        return additionalRequirementsName;
    }

    public void setAdditionalRequirementsName(String additionalRequirementsName) {
        this.additionalRequirementsName = additionalRequirementsName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public CompanyResponse getCompany() {
        return company;
    }

    public void setCompany(CompanyResponse company) {
        this.company = company;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
