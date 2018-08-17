package com.emi.hremi.model.log;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="log_login_secure_info")
public class LogLoginSecureInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "login_status")
    private String loginStatus;
    @Column(name = "login_message")
    private String loginMessage;
    @Column(name = "forgot_url_link")
    private String forgetUrlLink;


    @Column(name = "created_on")
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "modified_on")
    @UpdateTimestamp
    private Date modifiedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getForgetUrlLink() {
        return forgetUrlLink;
    }

    public void setForgetUrlLink(String forgetUrlLink) {
        this.forgetUrlLink = forgetUrlLink;
    }
}
