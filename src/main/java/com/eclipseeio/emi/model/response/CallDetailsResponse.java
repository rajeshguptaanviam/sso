package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.CallDetail;
import com.eclipseeio.emi.model.CallTopic;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallDetailsResponse implements Serializable {
    private Long id;
    private String callTopicName;
    private CompanyResponse companyResponse;
    private UserResponse userResponse;
    private CallTopicResponse callTopicResponse;

    private Date createdAt;
    private Date updatedAt;


    public CallDetailsResponse(CallDetail callDetail) {
        this.id = callDetail.getId();
        this.companyResponse = CompanyResponeFactory.create(callDetail.getCompany());
        this.userResponse = UserResponseFactory.create(callDetail.getUser());
        this.callTopicResponse = CallTopicResponeFactory.create(callDetail.getCallTopic());
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

    public CompanyResponse getCompanyResponse() {
        return companyResponse;
    }

    public void setCompanyResponse(CompanyResponse companyResponse) {
        this.companyResponse = companyResponse;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public CallTopicResponse getCallTopicResponse() {
        return callTopicResponse;
    }

    public void setCallTopicResponse(CallTopicResponse callTopicResponse) {
        this.callTopicResponse = callTopicResponse;
    }
}
