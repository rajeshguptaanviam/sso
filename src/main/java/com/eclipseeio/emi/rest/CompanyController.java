package com.eclipseeio.emi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eclipseeio.emi.dto.CompanyDTO;
import com.eclipseeio.emi.dto.OrganizationDTO;
import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.Industry;
import com.eclipseeio.emi.model.Organizations;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.CompanyRepository;
import com.eclipseeio.emi.repository.IndustryRepository;
import com.eclipseeio.emi.repository.OrganizationsRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;

@RestController
@RequestMapping(value = "/api/")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private OrganizationsRepository organizationsRepository;

	@Autowired
	private IndustryRepository industryRepository;

	@RequestMapping(method = RequestMethod.POST, value = "addCompany")
	@PreAuthorize("hasRole('ADMIN','HR')")
	public Result createCompany(CompanyDTO companyDTO) {
		Result result = Validator.validateCompany(companyDTO, companyRepository, organizationsRepository);
		if (result.isSuccess()) {
			try {
				Company company = new Company();
				company.setCompanyName(companyDTO.getCompanyName());
				company.setEmail(companyDTO.getEmail());
				company.setAddress(companyDTO.getAddress());
				company.setContactName(companyDTO.getContactName());
				company.setFax(companyDTO.getFax());
				company.setHealthAndSafetyInspection(companyDTO.getHealthAndSafetyInspection());
				company.setNeedToCarryOverVacation(companyDTO.getNeedToCarryOverVacation());
				Industry industry = industryRepository.findByIndustryName(companyDTO.getIndustry());
				if (industry != null) {
					company.setIndustry(industry);
				}
				companyRepository.save(company);
				result.setSuccess(true);
				result.setMessage(MessageResource.MESSAGE_CREATE);
			} catch (Exception e) {
				result.setSuccess(false);
				result.setMessage(e.getMessage());
			}
		}
		return result;
	}

}
