package com.eclipseeio.emi.dto;

import java.util.Date;

public class CallDetainsDTO {

    private Long companyId;
    private Long userId;
    private Long calltopicId;
    private String conversationContent;
    private Date createdAt;
    private Date updatedAt;
    private Boolean active;


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCalltopicId() {
        return calltopicId;
    }

    public void setCalltopicId(Long calltopicId) {
        this.calltopicId = calltopicId;
    }

    public String getConversationContent() {
        return conversationContent;
    }

    public void setConversationContent(String conversationContent) {
        this.conversationContent = conversationContent;
    }
}
