package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.AssignTo;
import com.eclipseeio.emi.model.Company;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssignResponse implements Serializable {
    private Long id;
    private String assignName;
    private Date createdAt;
    private Date updatedAt;

    public AssignResponse(AssignTo assignTo) {
        this.id = assignTo.getId();
        this.assignName = assignTo.getAssignName();
        this.createdAt = assignTo.getCreatedAt();
        this.updatedAt = assignTo.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName;
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
