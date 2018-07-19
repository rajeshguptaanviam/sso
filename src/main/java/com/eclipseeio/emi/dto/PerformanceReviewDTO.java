package com.eclipseeio.emi.dto;




import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
public class PerformanceReviewDTO {

    private Long id;
    private String performanceReviewName;
    private Date createdAt;
    private Date updatedAt;
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerformanceReviewName() {
        return performanceReviewName;
    }

    public void setPerformanceReviewName(String performanceReviewName) {
        this.performanceReviewName = performanceReviewName;
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
