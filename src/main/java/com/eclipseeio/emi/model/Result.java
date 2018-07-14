package com.eclipseeio.emi.model;

import com.eclipseeio.emi.model.response.CompanyResponse;
import com.eclipseeio.emi.model.response.UserResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private boolean success;

    private Page page;

    private List<Authority> authorities;
    private List<Industry> industries;
    private Industry industry;
    private Map<String, Long> countSet;
    private String message;
    private List<UserResponse> users;
    private List<CompanyResponse> companys;


    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }


    public Map<String, Long> getCountSet() {
        return countSet;
    }

    public void setCountSet(Map<String, Long> countSet) {
        this.countSet = countSet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public List<Industry> getIndustries() {
        return industries;
    }

    public void setIndustries(List<Industry> industries) {
        this.industries = industries;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }

    public List<CompanyResponse> getCompanys() {
        return companys;
    }

    public void setCompanys(List<CompanyResponse> companys) {
        this.companys = companys;

    }

    public List<UserResponse> getUsers() {
        return users;
    }
}
