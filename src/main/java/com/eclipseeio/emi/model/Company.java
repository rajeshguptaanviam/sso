package com.eclipseeio.emi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by fan.jin on 2016-10-15.
 */

@Entity
@Table(name = "company")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "website")
	private String website;
	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "phone")
	private Integer phone;

	@Column(name = "fax")
	private Integer fax;

	@Column(name = "email")
	private String email;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "WSIB_Firm_No")
	private String WSIBFirmNo;

	@Column(name = "postalCode")
	private String postalCode;

	@Column(name = "WSIB_Rate_Group_No")
	private String WSIBRateGroupNo;

	@Column(name = "health_and_safety_inspection")
	private String HealthAndSafetyInspection;

	@Column(name = "require_JHSC_Meeting")
	private String RequireJHSCMeeting;

	@Column(name = "need_help_with_health_and_safety")
	private String NeedHelpWithHealthAndSafety;

	@Column(name = "need_to_carry_over_vacation")
	private Boolean NeedToCarryOverVacation;

	@OneToOne(fetch= FetchType.EAGER)
	private Industry industry;

	@OneToOne(fetch= FetchType.EAGER)
	private States states;

	@OneToOne(fetch= FetchType.EAGER)
	private AdditionalRequirements additionalRequirements;

	@OneToOne(fetch= FetchType.EAGER)
	private Benefits benefits;
	@OneToOne(fetch= FetchType.EAGER)
	private AssignTo assignTo;

	@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "organizations_id", referencedColumnName = "id")
	private Organizations organizations;

	 @OneToMany(targetEntity = CompanyDepartment.class, mappedBy = "company")
	 private List<CompanyDepartment> companyDepartment;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User users;

	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
 	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<CallDetail> callDetail;


    public List<CallDetail> getCallDetail() {
        return callDetail;
    }

    public void setCallDetail(List<CallDetail> callDetail) {
        this.callDetail = callDetail;
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

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public States getStateProv() {
		return states;
	}

	public void setStateProv(States states) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public States getStates() {
		return states;
	}

	public void setStates(States states) {
		this.states = states;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Benefits getBenefits() {
		return benefits;
	}

	public void setBenefits(Benefits benefits) {
		this.benefits = benefits;
	}

	public AssignTo getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(AssignTo assignTo) {
		this.assignTo = assignTo;
	}

	public AdditionalRequirements getAdditionalRequirements() {
		return additionalRequirements;
	}

	public void setAdditionalRequirements(AdditionalRequirements additionalRequirements) {
		this.additionalRequirements = additionalRequirements;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
