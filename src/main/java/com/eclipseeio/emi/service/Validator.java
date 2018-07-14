package com.eclipseeio.emi.service;

import com.eclipseeio.emi.dto.CompanyDTO;
import com.eclipseeio.emi.dto.IndustryDto;
import com.eclipseeio.emi.dto.OrganizationDTO;
import com.eclipseeio.emi.dto.UserDto;
import com.eclipseeio.emi.model.*;
import com.eclipseeio.emi.repository.*;

public class Validator {

	/**
	 * @param user
	 * @param userRepository
	 * @return
	 */
	public static Result validateNewUser(UserDto user, UserRepository userRepository) {
		Result result = new Result();
		result.setSuccess(true);
		if (user == null) {
			result.setMessage("no input params found");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(user.getFirstname())) {
			result.setMessage("firstname is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(user.getLastname())) {
			result.setMessage("lastname is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(user.getEmail())) {
			result.setMessage("email is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(user.getUsername())) {
			result.setMessage("username is required*");
			result.setSuccess(false);
		} else if (user.getUsername().length() < 4) {
			result.setMessage("username must be between 4 and 100");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(user.getPassword())) {
			result.setMessage("password is required*");
			result.setSuccess(false);
		} else if (user.getPassword().length() < 4) {
			result.setMessage("password must be between 4 and 100");
			result.setSuccess(false);
		}
		if (result.isSuccess()) {
			User _user = userRepository.findByUsername(user.getUsername());
			if (_user != null) {
				result.setMessage("Please try another username its already taken");
				result.setSuccess(false);
			}
		}

		if (result.isSuccess()) {
			User _user = userRepository.findByEmail(user.getEmail());
			if (_user != null) {
				result.setMessage("Please try another email its already taken");
				result.setSuccess(false);
			}
		}

		return result;
	}

	public static Result validateOrganization(OrganizationDTO organizationDTO,
			OrganizationsRepository organizationsRepository) {
		Result result = new Result();
		result.setSuccess(true);
		if (organizationDTO == null) {
			result.setMessage("no input params found");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(organizationDTO.getOrganizationName())) {
			result.setMessage("Organization name is required*");
			result.setSuccess(false);
		}
		if (result.isSuccess()) {
			Organizations _organizations = organizationsRepository
					.findByOrganizationName(organizationDTO.getOrganizationName());
			if (_organizations != null) {
				result.setMessage("Please try another Organization name  its already taken");
				result.setSuccess(false);
			}
		}

		return result;
	}



	public static Result validateIndustry(IndustryDto industryDto,
										  IndustryRepository industryRepository) {
		Result result = new Result();
		result.setSuccess(true);
		if (industryDto == null) {
			result.setMessage("no input params found");
			result.setSuccess(false);
		}
		Industry industry=industryRepository.findByIndustryName(industryDto.getIndustryName());

			if (industry != null) {
				result.setMessage("Please try another industry name.It is already taken");
				result.setSuccess(false);
			}

		return result; }


	public static Result validateCompany(CompanyDTO companyDTO, CompanyRepository companyRepository,
			OrganizationsRepository organizationsRepository) {
		Result result = new Result();
		result.setSuccess(true);
		if (companyDTO == null) {
			result.setMessage("no input params found");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getOrganizationName())) {
			result.setMessage("Organization Name name is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getCompanyName())) {
			result.setMessage("Company name is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getAddress())) {
			result.setMessage("Address is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getContactName())) {
			result.setMessage("Contact is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getHealthAndSafetyInspection())) {
			result.setMessage("Health And Safety Inspection  is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getNeedHelpWithHealthAndSafety())) {
			result.setMessage("Need Help With Health And Safety Inspection  is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getWebsite())) {
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getwSIBFirmNo())) {
			result.setMessage("WSIB Firm No is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getEmail())) {
			result.setMessage("Email is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getAssignTo())) {
			result.setMessage("Assign To is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getBenfites())) {
			result.setMessage("Benfites is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getAdditionalRequirements())) {
			result.setMessage("Additional Requirements To is required*");
			result.setSuccess(false);
		} else if (TextUtils.isEmpty(companyDTO.getState())) {
			result.setMessage("State is required*");
			result.setSuccess(false);
		}
		if (result.isSuccess()) {
			Company _company = companyRepository.findById(Long.parseLong(companyDTO.getCompanyName()));
			if (_company != null) {
				result.setMessage("Please try another Company Name  its already taken");
				result.setSuccess(false);
			}
		}

		return result;
	}
}
