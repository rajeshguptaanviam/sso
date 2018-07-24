package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyResponse implements Serializable {
    private Long id;
    private String companyName;
    private String address;
    private String city;
    private String website;
    private String contactName;
    private Integer phone;
    private Integer fax;
    private String email;
    private String WSIBFirmNo;
    private String WSIBRateGroupNo;
    private String HealthAndSafetyInspection;
    private String RequireJHSCMeeting;
    private String NeedHelpWithHealthAndSafety;
    private Boolean NeedToCarryOverVacation;
    private IndustryResponse industry;
    private StatesResponse states;
    private OrganizationResponse organizations;
    private AdditionalRequementResponse additionalRequirements;
    //  private List<CompanyDepartment> companyDepartment;
  private UserResponse users;
    //  private List<CallDetail> callDetail;
    private final Date createdAt;
    private final Date updatedAt;
    //  private final UserResponse user;
    // private final JwtProject project;


    public CompanyResponse(Company enquiry) {
        this.id = enquiry.getId();
        this.email = enquiry.getEmail();
        this.address = enquiry.getAddress();
        this.city = enquiry.getCity();
        this.companyName = enquiry.getCompanyName();
        this.contactName = enquiry.getContactName();
        this.fax = enquiry.getFax();
        this.HealthAndSafetyInspection = enquiry.getHealthAndSafetyInspection();
        this.NeedHelpWithHealthAndSafety = enquiry.getNeedHelpWithHealthAndSafety();
        this.phone = enquiry.getPhone();
        this.RequireJHSCMeeting = enquiry.getRequireJHSCMeeting();
        this.website = enquiry.getWebsite();
        this.WSIBFirmNo = enquiry.getWSIBFirmNo();
        this.WSIBRateGroupNo = enquiry.getWSIBRateGroupNo();
        this.organizations = OrganizationsResponeFactory.create(enquiry.getOrganizations());
        this.states = StatesResponeFactory.create(enquiry.getStates());
        this.industry = IndustryResponeFactory.create(enquiry.getIndustry());
        this.additionalRequirements = AdditionalRequrmentResponeFactory.create(enquiry.getAdditionalRequirements());
        this.users = UserResponseFactory.create(enquiry.getUser());

        this.createdAt = enquiry.getCreatedAt();
        this.updatedAt = enquiry.getUpdatedAt();
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWSIBFirmNo() {
        return WSIBFirmNo;
    }

    public void setWSIBFirmNo(String WSIBFirmNo) {
        this.WSIBFirmNo = WSIBFirmNo;
    }

    public String getWSIBRateGroupNo() {
        return WSIBRateGroupNo;
    }

    public void setWSIBRateGroupNo(String WSIBRateGroupNo) {
        this.WSIBRateGroupNo = WSIBRateGroupNo;
    }

    public String getHealthAndSafetyInspection() {
        return HealthAndSafetyInspection;
    }

    public void setHealthAndSafetyInspection(String healthAndSafetyInspection) {
        HealthAndSafetyInspection = healthAndSafetyInspection;
    }

    public String getRequireJHSCMeeting() {
        return RequireJHSCMeeting;
    }

    public void setRequireJHSCMeeting(String requireJHSCMeeting) {
        RequireJHSCMeeting = requireJHSCMeeting;
    }

    public String getNeedHelpWithHealthAndSafety() {
        return NeedHelpWithHealthAndSafety;
    }

    public void setNeedHelpWithHealthAndSafety(String needHelpWithHealthAndSafety) {
        NeedHelpWithHealthAndSafety = needHelpWithHealthAndSafety;
    }

    public Boolean getNeedToCarryOverVacation() {
        return NeedToCarryOverVacation;
    }

    public void setNeedToCarryOverVacation(Boolean needToCarryOverVacation) {
        NeedToCarryOverVacation = needToCarryOverVacation;
    }

    public IndustryResponse getIndustry() {
        return industry;
    }

    public void setIndustry(IndustryResponse industry) {
        this.industry = industry;
    }

    public StatesResponse getStates() {
        return states;
    }

    public void setStates(StatesResponse states) {
        this.states = states;
    }

    public OrganizationResponse getOrganizations() {
        return organizations;
    }

    public void setOrganizations(OrganizationResponse organizations) {
        this.organizations = organizations;
    }

    public AdditionalRequementResponse getAdditionalRequirements() {
        return additionalRequirements;
    }

    public void setAdditionalRequirements(AdditionalRequementResponse additionalRequirements) {
        this.additionalRequirements = additionalRequirements;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public UserResponse getUsers() {
        return users;
    }

    public void setUsers(UserResponse users) {
        this.users = users;
    }

}
