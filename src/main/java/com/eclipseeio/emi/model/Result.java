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
    private List<Benefits> benefits;
    private Benefits _benefits;
    private List<States> states;
    private States _states;
    private AdditionalRequirements additionalRequirements;
    private List<AdditionalRequirements> additionalRequirementsList;
    private AssignTo assignTo;
    private List<AssignTo> assignToList;
    private List<CompanyDepartment> companyDepartments;
    private CompanyDepartment companyDepartment;
    private User user;


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

    public List<Benefits> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<Benefits> benefits) {
        this.benefits = benefits;
    }

    public Benefits get_benefits() {
        return _benefits;
    }

    public void set_benefits(Benefits _benefits) {
        this._benefits = _benefits;
    }


    public List<States> getStates() {
        return states;
    }

    public void setStates(List<States> states) {
        this.states = states;
    }

    public States get_states() {
        return _states;
    }

    public void set_states(States _states) {
        this._states = _states;
    }


    public AdditionalRequirements getAdditionalRequirements() {
        return additionalRequirements;
    }

    public void setAdditionalRequirements(AdditionalRequirements additionalRequirements) {
        this.additionalRequirements = additionalRequirements;
    }

    public List<AdditionalRequirements> getAdditionalRequirementsList() {
        return additionalRequirementsList;
    }

    public void setAdditionalRequirementsList(List<AdditionalRequirements> additionalRequirementsList) {
        this.additionalRequirementsList = additionalRequirementsList;
    }


    public AssignTo getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(AssignTo assignTo) {
        this.assignTo = assignTo;
    }

    public List<AssignTo> getAssignToList() {
        return assignToList;
    }

    public void setAssignToList(List<AssignTo> assignToList) {
        this.assignToList = assignToList;
    }
        public List<CompanyDepartment> getCompanyDepartments () {
            return companyDepartments;
        }

    public void setCompanyDepartments(List<CompanyDepartment> companyDepartments) {
        this.companyDepartments = companyDepartments;
    }

    public CompanyDepartment getCompanyDepartment() {
        return companyDepartment;
    }

    public void setCompanyDepartment(CompanyDepartment companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;

    }
}
