package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.Industry;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndustryResponse implements Serializable {
    private Long id;
    private String industryName;
    private Date createdAt;
    private Date updatedAt;


    public IndustryResponse(Industry enquiry) {
        this.id = enquiry.getId();
        this.industryName =enquiry.getIndustryName();
        this.createdAt = enquiry.getCreatedAt();
        this.updatedAt = enquiry.getUpdatedAt();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }
}
