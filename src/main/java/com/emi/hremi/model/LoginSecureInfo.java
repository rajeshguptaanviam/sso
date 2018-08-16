package com.emi.hremi.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="login_secure_info")
public class LoginSecureInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    @NotNull
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email can not be empty")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    @NotEmpty(message = "password can not be empty")
    private String password;

    @Column(name = "username")
    @NotNull
    @Size(min = 6, message = "Name should have atleast 6 characters")
    private String username;

    @Column(name = "company_name")
    @NotNull(message = "Company Name cannot be null")
    @NotEmpty(message = "company name can not be empty")
    private String companyName;


    /*@Column(name = "target_url")
    @NotNull(message = "Target URL cannot be null")
    @NotEmpty(message = "Target URL cannot be empty")
    private String targetUrl;*/


    @Column(name = "last_password_update")
    private Date lastPasswordUpdate;

    @Column(name = "link_status")
    private Integer linkStatus;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

   /* public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
*/
    public Date getLastPasswordUpdate() {
        return lastPasswordUpdate;
    }

    public void setLastPasswordUpdate(Date lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
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

    public Integer getLinkStatus() {
        return linkStatus;
    }
    public void setLinkStatus(Integer linkStatus) {
        this.linkStatus = linkStatus;
    }
}
