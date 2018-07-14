package com.eclipseeio.emi.rest;

import com.eclipseeio.emi.dto.CompanyDTO;
import com.eclipseeio.emi.model.*;
import com.eclipseeio.emi.model.response.CompanyResponeFactory;
import com.eclipseeio.emi.model.response.CompanyResponse;
import com.eclipseeio.emi.model.response.UserResponse;
import com.eclipseeio.emi.model.specifications.CompanySpecification;
import com.eclipseeio.emi.model.specifications.UserSpecification;
import com.eclipseeio.emi.repository.CompanyRepository;
import com.eclipseeio.emi.repository.IndustryRepository;
import com.eclipseeio.emi.repository.OrganizationsRepository;
import com.eclipseeio.emi.repository.UserRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private OrganizationsRepository organizationsRepository;

	@Autowired
	private IndustryRepository industryRepository;


	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST, value = "addCompany")
	@PreAuthorize("hasAnyRole('HR','ADMIN')")
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
				Organizations organizations=organizationsRepository.findByOrganizationName(companyDTO.getCompanyName());
				if (organizations != null){ company.setOrganizations(organizations);}
				else{
					result.setMessage("Please provide a valid organization does not exist");
					return result;
				}
				Industry industry = industryRepository.findByIndustryName(companyDTO.getIndustry());
				if (industry != null){ company.setIndustry(industry);}
				else{
					result.setMessage("Please provide a valid Industry does not exist");
					return result;
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




	@RequestMapping(value = "deleteCompany/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable Long id) {
		Result result = new Result();
		result.setSuccess(true);
		try {
			Company company = companyRepository.findById(id);
			if (company != null) {
				//com
				result.setMessage(MessageResource.MESSAGE_DELETE);
				companyRepository.delete(company);
			} else {
				result.setSuccess(false);
				result.setMessage(MessageResource.MESSAGE_ADMIN_DELETE);
			}
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			result.setSuccess(false);
		}
		return result;
	}

	@RequestMapping(value = "company", method = RequestMethod.GET)
	public Result users(@Param("pageable")Pageable pageable, @RequestParam Map<String, String> queryParameters) {
		Result result = new Result();
		try {
			if (pageable == null)
				pageable = new PageRequest(0, 10);

			String query = queryParameters.get("query");
			Page<Company> page;
			if (query != null && query.trim().length() > 0) {
				page = companyRepository.findAll(new CompanySpecification(query), pageable);
			} else {
				page = companyRepository.findAll(pageable);
			}
			List<CompanyResponse> jwtUsers = new ArrayList<>();
			page.getContent().forEach(company -> jwtUsers.add(CompanyResponeFactory.create(company)));
			com.eclipseeio.emi.model.Page p = new com.eclipseeio.emi.model.Page();
			p.setTotalElements(page.getTotalElements());
			p.setNumberOfElements(page.getNumberOfElements());
			p.setTotalPages(page.getTotalPages());
			result.setPage(p);
			result.setCompanys(jwtUsers);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
