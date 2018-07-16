package com.eclipseeio.emi.dto;

import com.eclipseeio.emi.model.Company;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

public class AdditionalRequirementsDTO {

    private Long id;
    private String additionalRequirementsName;
    private Date createdAt;
    private Company company;
    private Date updatedAt;
    private Boolean active;


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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


}
