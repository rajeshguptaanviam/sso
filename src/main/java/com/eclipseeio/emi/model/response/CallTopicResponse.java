package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.CallTopic;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class CallTopicResponse {


    private Long id;


    private String callTopicName;

    private Boolean active;


    private Date createdAt;


    private Date updatedAt;

    public CallTopicResponse(CallTopic callTopic) {
        this.id = callTopic.getId();
        this.callTopicName = callTopic.getCallTopicName();
        this.active = callTopic.getActive();
        this.createdAt = callTopic.getCreatedAt();
        this.updatedAt = callTopic.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallTopicName() {
        return callTopicName;
    }

    public void setCallTopicName(String callTopicName) {
        this.callTopicName = callTopicName;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
