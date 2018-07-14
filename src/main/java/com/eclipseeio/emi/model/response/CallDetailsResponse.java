package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.CallDetail;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallDetailsResponse implements Serializable {
    private Long id;
    private String callTopicName;
    private Date createdAt;
    private Date updatedAt;


    public CallDetailsResponse(CallDetail callDetail) {
        this.id = callDetail.getId();
        this.callTopicName = callDetail.getCallTopic();
        this.createdAt = callDetail.getCreatedAt();
        this.updatedAt = callDetail.getUpdatedAt();
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
}
