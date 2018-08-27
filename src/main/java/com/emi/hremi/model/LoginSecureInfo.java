package com.emi.hremi.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull(message = "password can not be null")
    @Size(min = 6,message = "password lenght must be 6 char.")
    private String password;

    @Column(name = "username")
    @NotNull
    @Size(min = 6, message = "Name should have atleast 6 characters")
    private String username;

    @Column(name = "company_code",nullable = false)
    @NotNull(message = "Company code cannot be null")
    @NotEmpty(message = "company code can not be empty")
    private String companyCode;

    @Column(name = "last_password_update")
    private Date lastPasswordUpdate;

    @Column(name = "link_status")
    private Integer linkStatus;

    @Column(name = "token")
    private String  token;

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

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
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

    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    @NotNull
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(@NotNull String companyCode) {
        this.companyCode = companyCode;
    }

    public Date getLastPasswordUpdate() {
        return lastPasswordUpdate;
    }

    public void setLastPasswordUpdate(Date lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }

    public Integer getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(Integer linkStatus) {
        this.linkStatus = linkStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
}
