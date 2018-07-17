package com.eclipseeio.emi.rest;

import com.eclipseeio.emi.dto.OrganizationDTO;
import com.eclipseeio.emi.model.Organizations;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.OrganizationsRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class OrganizationsController {

	@Autowired
	private OrganizationsRepository organizationsRepository;

	@RequestMapping(method = RequestMethod.POST, value = "addOrganization")
	@PreAuthorize("hasAnyRole('ADMIN','HR')")
	public Result createOrg(OrganizationDTO organizationDTO) {
		Result result = Validator.validateOrganization(organizationDTO, organizationsRepository);
		if (result.isSuccess()) {
			try {
				Organizations organizations = new Organizations();
				organizations.setOrganizationName(organizationDTO.getOrganizationName());
				organizations.setActive(true);
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


	@RequestMapping(value = "deleteOrganizations/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('ADMIN','HR')")
	public Result deleteOrganizations(@PathVariable Long id) {
		Result result = new Result();
		try {
			Organizations organizations = organizationsRepository.findByIdAndActiveIsTrue(id);
			if (organizations != null) {
				if (organizations.getActive().equals(true)) {
					organizations.setActive(false);
					result.setMessage(MessageResource.MESSAGE_DELETE);
					organizationsRepository.save(organizations);
				} else {
					result.setSuccess(true);
					result.setMessage(MessageResource.MESSAGE_DELETE);
				}
			}
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "getOrganizations", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ADMIN','HR')")
	public Result getOrganizations() {
		Result result = new Result();
		try {
			List<Organizations> organizationsList = organizationsRepository.findAllByActiveIsTrue();
			result.setOrganizationsList(organizationsList);
			result.setSuccess(true);

		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}


	@RequestMapping(value = "getOrganizationById/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ADMIN','HR')")
	public Result getOrgnizationsById(@PathVariable Long id) {
		Result result = new Result();
		try {

			Organizations organizations = organizationsRepository.findByIdAndActiveIsTrue(id);
			if (organizations != null) {
				result.setOrganizations(organizations);
				result.setSuccess(true);
			} else {
				result.setMessage("no data found");
			}
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}


	@RequestMapping(method = RequestMethod.PUT, value = "updateOrganizations/{id}")
	public Result updateOrganizations(@PathVariable Long id, @RequestBody OrganizationDTO organizationDTO) {

		Result result = new Result();
		try {
			Organizations organizations = organizationsRepository.findByIdAndActiveIsTrue(id);

			if (organizations != null) {
				organizations.setOrganizationName(organizationDTO.getOrganizationName());
				organizationsRepository.save(organizations);
				result.setSuccess(true);
				result.setMessage(MessageResource.MESSAGE_UPDATE);
			} else {
				result.setMessage(MessageResource.MESSAGE_DATA_NOT_FOUND);
			}
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
			e.getClass();
		}
		return result;
	}

}
