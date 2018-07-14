package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.Organizations;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationResponse implements Serializable {
    private Long id;
    private String organizationName;
    private Date createdAt;
    private Date updatedAt;

    public OrganizationResponse(Organizations organizations) {
        this.id = organizations.getId();
        this.organizationName = organizations.getOrganizationName();
        this.createdAt = organizations.getCreatedAt();
        this.updatedAt = organizations.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
