package com.eclipseeio.emi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eclipseeio.emi.dto.OrganizationDTO;
import com.eclipseeio.emi.model.Organizations;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.OrganizationsRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;

@RestController
@RequestMapping(value = "/api/")
public class OrganizationsController {

	@Autowired
	private OrganizationsRepository organizationsRepository;

	@RequestMapping(method = RequestMethod.POST, value = "addOrganization")
<<<<<<< HEAD
	/*@PreAuthorize("hasRole('ADMIN','HR')")*/
=======
	@PreAuthorize("hasAnyRole('ADMIN','HR')")
>>>>>>> 09849ff10ffdd7661d830e177018f64d3c5e0243
	public Result createOrg(OrganizationDTO organizationDTO) {
		Result result = Validator.validateOrganization(organizationDTO, organizationsRepository);
		if (result.isSuccess()) {
			try {
				Organizations organizations = new Organizations();
				organizations.setOrganizationName(organizationDTO.getOrganizationName());
				organizationsRepository.save(organizations);
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
