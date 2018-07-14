package com.eclipseeio.emi.dto;

/**
 * Created by fan.jin on 2016-10-15.
 */

public class CompanyDTO {

	private Long id;

	private String companyName;
	private String address;
	private String city;
	private String website;
	private String state;
	private String organizationName;
	private String industry;
	private String benfites;
	private String assignTo;
	private String additionalRequirements;
	

	
	private String email;
	private String contactName;

	private Integer phone;

	private Integer fax;

	private String WSIBFirmNo;

	private String WSIBRateGroupNo;

	private String HealthAndSafetyInspection;

	private String RequireJHSCMeeting;

	private String NeedHelpWithHealthAndSafety;

	private Boolean NeedToCarryOverVacation;

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

	public String getWSIBFirmNo() {
		return WSIBFirmNo;
	}

	public void setWSIBFirmNo(String wSIBFirmNo) {
		WSIBFirmNo = wSIBFirmNo;
	}

	public String getWSIBRateGroupNo() {
		return WSIBRateGroupNo;
	}

	public void setWSIBRateGroupNo(String wSIBRateGroupNo) {
		WSIBRateGroupNo = wSIBRateGroupNo;
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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

}
