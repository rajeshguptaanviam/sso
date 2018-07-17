package com.eclipseeio.emi.dto;

/**
 * Created by fan.jin on 2016-10-15.
 */

public class CompanyDTO {

    private Long id;
    private Long userId;
    private Long companyId;
    private String companyName;
    private String address;
    private String city;
    private String website;
    private String state;
    private Long organizationId;
    private String organizationName;
    private String postalCode;
    private String industry;
    private String benfites;
    private String assignTo;
    private String additionalRequirements;


    private String email;
    private String contactName;

    private Integer phone;

    private Integer fax;

    private String wSIBFirmNo;

    private String wSIBRateGroupNo;

    private String healthAndSafetyInspection;

    private String requireJHSCMeeting;

    private String needHelpWithHealthAndSafety;

    private Boolean needToCarryOverVacation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getBenfites() {
        return benfites;
    }

    public void setBenfites(String benfites) {
        this.benfites = benfites;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getAdditionalRequirements() {
        return additionalRequirements;
    }

    public void setAdditionalRequirements(String additionalRequirements) {
        this.additionalRequirements = additionalRequirements;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getwSIBFirmNo() {
        return wSIBFirmNo;
    }

    public void setwSIBFirmNo(String wSIBFirmNo) {
        this.wSIBFirmNo = wSIBFirmNo;
    }

    public String getwSIBRateGroupNo() {
        return wSIBRateGroupNo;
    }

    public void setwSIBRateGroupNo(String wSIBRateGroupNo) {
        this.wSIBRateGroupNo = wSIBRateGroupNo;
    }

    public String getHealthAndSafetyInspection() {
        return healthAndSafetyInspection;
    }

    public void setHealthAndSafetyInspection(String healthAndSafetyInspection) {
        this.healthAndSafetyInspection = healthAndSafetyInspection;
    }

    public String getRequireJHSCMeeting() {
        return requireJHSCMeeting;
    }

    public void setRequireJHSCMeeting(String requireJHSCMeeting) {
        this.requireJHSCMeeting = requireJHSCMeeting;
    }

    public String getNeedHelpWithHealthAndSafety() {
        return needHelpWithHealthAndSafety;
    }

    public void setNeedHelpWithHealthAndSafety(String needHelpWithHealthAndSafety) {
        this.needHelpWithHealthAndSafety = needHelpWithHealthAndSafety;
    }

    public Boolean getNeedToCarryOverVacation() {
        return needToCarryOverVacation;
    }

    public void setNeedToCarryOverVacation(Boolean needToCarryOverVacation) {
        this.needToCarryOverVacation = needToCarryOverVacation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
