package com.eclipseeio.emi.model.response;

import com.eclipseeio.emi.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
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
 //   private Industry industry;
  //  private States states;
  //  private Organizations organizations;
  //  private List<CompanyDepartment> companyDepartment;
   // private User users;
  //  private List<CallDetail> callDetail;
    private final Integer createdOn;
    private final String modifiedOn;
  //  private final UserResponse user;
   // private final JwtProject project;


    public CompanyResponse(Company enquiry) {
        this.id = enquiry.getId();
        this.email = enquiry.getEmail();
        this.address = enquiry.getAddress();
        this.city = enquiry.getCity();
        this.companyName = enquiry.getCompanyName();
        this.contactName = enquiry.getContactName();
        this.createdOn=enquiry.getFax();
        this.modifiedOn = enquiry.getHealthAndSafetyInspection();
        this.NeedHelpWithHealthAndSafety= enquiry.getNeedHelpWithHealthAndSafety();
        this.phone =enquiry.getPhone();
        this.RequireJHSCMeeting = enquiry.getRequireJHSCMeeting();
        this.website= enquiry.getWebsite();
        this.WSIBFirmNo = enquiry.getWSIBFirmNo();
        this.WSIBRateGroupNo =enquiry.getWSIBRateGroupNo();
        //this.user = UserResponseFactory.create(enquiry.getUsers());
      //  this.project = JwtProjectFactory.create(enquiry.getProject());
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

   /* public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public Organizations getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organizations organizations) {
        this.organizations = organizations;
    }

    public List<CompanyDepartment> getCompanyDepartment() {
        return companyDepartment;
    }

    public void setCompanyDepartment(List<CompanyDepartment> companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public List<CallDetail> getCallDetail() {
        return callDetail;
    }

    public void setCallDetail(List<CallDetail> callDetail) {
        this.callDetail = callDetail;
    }
*/
    public Integer getCreatedOn() {
        return createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    /*public UserResponse getUser() {
        return user;
    }*/

  /*  public JwtProject getProject() {
        return project;
    }*/
}
