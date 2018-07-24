package com.eclipseeio.emi.dto;

import java.util.Date;

public class CallTopicDTO {

    private Long id;

    private String callTopicName;


    private Date createdAt;

    private Date updatedAt;

    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCallTopicName() {
        return callTopicName;
    }

    public void setCallTopicName(String callTopicName) {
        this.callTopicName = callTopicName;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
