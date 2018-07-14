package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.Benefits;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BenifitesResponse implements Serializable {
    private Long id;
    private String benifitesName;
    private Date createdAt;
    private Date updatedAt;

    public BenifitesResponse(Benefits benefits) {
        this.id = benefits.getId();
        this.benifitesName = benefits.getBenefitsName();
        this.createdAt = benefits.getCreatedAt();
        this.updatedAt = benefits.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBenifitesName() {
        return benifitesName;
    }

    public void setBenifitesName(String benifitesName) {
        this.benifitesName = benifitesName;
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
