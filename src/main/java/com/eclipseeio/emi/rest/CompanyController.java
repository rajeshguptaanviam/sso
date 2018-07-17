package com.eclipseeio.emi.rest;

import com.eclipseeio.emi.dto.CompanyDTO;
import com.eclipseeio.emi.model.*;
import com.eclipseeio.emi.model.response.CompanyResponeFactory;
import com.eclipseeio.emi.model.response.CompanyResponse;
import com.eclipseeio.emi.model.specifications.CompanySpecification;
import com.eclipseeio.emi.repository.*;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.hibernate.tool.hbm2ddl.TableMetadata;
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
    private StatesRepository statesRepository;

    @Autowired
    private BenefitsRepository benefitsRepository;
    @Autowired
    private AssignToRepository assignToRepository;
    @Autowired
    private AdditionalRequirementsRepository additionalRequirementsRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "addCompany")
    @PreAuthorize("hasAnyRole('HR','ADMIN')")
    public Result createCompany(@RequestBody CompanyDTO companyDTO) {
        Result result = Validator.validateCompany(companyDTO, companyRepository, organizationsRepository);
        User user_=userRepository.findById(companyDTO.getUserId());
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
                company.setNeedHelpWithHealthAndSafety(companyDTO.getNeedHelpWithHealthAndSafety());
                company.setCity(companyDTO.getCity());
                company.setRequireJHSCMeeting(companyDTO.getRequireJHSCMeeting());
                company.setWebsite(companyDTO.getWebsite());
                company.setWSIBFirmNo(companyDTO.getwSIBFirmNo());
                company.setWSIBRateGroupNo(companyDTO.getwSIBRateGroupNo());
                Organizations organizations = organizationsRepository.findById(companyDTO.getOrganizationId());
                if(user_!=null){
                    company.setUsers(user_);
                }
                if (organizations != null) {
                    company.setOrganizations(organizations);
                } else {
                    result.setMessage("Please provide a valid organization does not exist");
                    return result;
                }
                Industry industry = industryRepository.findById(Long.parseLong(companyDTO.getIndustry()));
                if (industry != null) {
                    company.setIndustry(industry);
                } else {
                    result.setMessage("Please provide a valid Industry does not exist");
                    return result;
                }
                States states = statesRepository.findById(Long.parseLong(companyDTO.getState()));
                if (states != null) {
                    company.setStates(states);
                } else {
                    result.setMessage("Please provide a valid State name & it  does not exist");
                    return result;
                }

                Benefits benefits = benefitsRepository.findById(Long.parseLong(companyDTO.getBenfites()));
                if (states != null) {
                    company.setBenefits(benefits);
                } else {
                    result.setMessage("Please provide a valid benefits name & it  does not exist");
                    return result;
                }


                AssignTo assignTo = assignToRepository.findById(Long.parseLong(companyDTO.getAssignTo()));
                if (states != null) {
                    company.setAssignTo(assignTo);
                } else {
                    result.setMessage("Please provide a valid Assign name & it  does not exist");
                    return result;
                }

                AdditionalRequirements additionalRequirements = additionalRequirementsRepository.findById(Long.parseLong(companyDTO.getAdditionalRequirements()));
                if (states != null) {
                    company.setAdditionalRequirements(additionalRequirements);
                } else {
                    result.setMessage("Please provide a valid Additional Requirements name & it  does not exist");
                    return result;
                }
                companyRepository.save(company);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_CREATE);
            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage(e.getMessage());
                e.printStackTrace();
            }
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCompany/{id}")
    @PreAuthorize("hasAnyRole('HR','ADMIN')")
    public Result updateCompany(@RequestBody CompanyDTO companyDTO, @PathVariable Long id) {
        Result result = Validator.validateCompany(companyDTO, companyRepository, organizationsRepository);
        if (result.isSuccess()) {
            try {
                Company company = companyRepository.findById(id);
                if (company != null) {
                    if (!company.getCompanyName().equalsIgnoreCase(companyDTO.getCompanyName())) {
                        company.setCompanyName(companyDTO.getCompanyName());
                    }
                    if (!company.getEmail().equalsIgnoreCase(companyDTO.getEmail())) {
                        company.setEmail(companyDTO.getEmail());
                    }
                    if (!company.getAddress().equalsIgnoreCase(companyDTO.getAddress())) {
                        company.setAddress(companyDTO.getAddress());
                    }
                    if (!company.getContactName().equalsIgnoreCase(companyDTO.getContactName())) {
                        company.setContactName(companyDTO.getContactName());
                    }
                    if (!company.getFax().toString().equalsIgnoreCase(companyDTO.getFax().toString())) {
                        company.setFax(companyDTO.getFax());
                    }
                    if (!company.getHealthAndSafetyInspection().equalsIgnoreCase(companyDTO.getHealthAndSafetyInspection())) {
                        company.setHealthAndSafetyInspection(company.getNeedHelpWithHealthAndSafety());
                    }
                    if (!company.getNeedToCarryOverVacation().toString().equalsIgnoreCase(companyDTO.getNeedHelpWithHealthAndSafety())) {
                        company.setNeedToCarryOverVacation(companyDTO.getNeedToCarryOverVacation());
                    }

                    if (!company.getCity().toString().equalsIgnoreCase(companyDTO.getCity())) {
                        company.setCity(companyDTO.getCity());
                    }
                    if (!company.getWebsite().toString().equalsIgnoreCase(companyDTO.getWebsite())) {
                        company.setWebsite(companyDTO.getWebsite());
                    }

                    if (!company.getWSIBFirmNo().toString().equalsIgnoreCase(companyDTO.getwSIBFirmNo())) {
                        company.setWSIBFirmNo(companyDTO.getwSIBFirmNo());
                    }

                    if (!company.getWSIBRateGroupNo().toString().equalsIgnoreCase(companyDTO.getwSIBRateGroupNo())) {
                        company.setWSIBRateGroupNo(companyDTO.getwSIBRateGroupNo());
                    }


                    if (!company.getRequireJHSCMeeting().toString().equalsIgnoreCase(companyDTO.getRequireJHSCMeeting())) {
                        company.setRequireJHSCMeeting(companyDTO.getRequireJHSCMeeting());
                    }
                    if (!company.getNeedHelpWithHealthAndSafety().toString().equalsIgnoreCase(companyDTO.getNeedHelpWithHealthAndSafety())) {
                        company.setNeedHelpWithHealthAndSafety(companyDTO.getNeedHelpWithHealthAndSafety());
                    }


                    Organizations organizations = organizationsRepository.findById(companyDTO.getOrganizationId());
                    if (organizations != null) {
                        company.setOrganizations(organizations);
                    } else {
                        result.setMessage("Please provide a valid organization does not exist");
                        return result;
                    }
                    Industry industry = industryRepository.findById(Long.parseLong(companyDTO.getIndustry()));
                    if (industry != null) {
                        company.setIndustry(industry);
                    } else {
                        result.setMessage("Please provide a valid Industry does not exist");
                        return result;
                    }
                    States states = statesRepository.findById(Long.parseLong(companyDTO.getState()));
                    if (states != null) {
                        company.setStates(states);
                    } else {
                        result.setMessage("Please provide a valid State name & it  does not exist");
                        return result;
                    }

                    Benefits benefits = benefitsRepository.findById(Long.parseLong(companyDTO.getBenfites()));
                    if (states != null) {
                        company.setBenefits(benefits);
                    } else {
                        result.setMessage("Please provide a valid benefits name & it  does not exist");
                        return result;
                    }
                    AssignTo assignTo = assignToRepository.findById(Long.parseLong(companyDTO.getAssignTo()));
                    if (states != null) {
                        company.setAssignTo(assignTo);
                    } else {
                        result.setMessage("Please provide a valid Assign name & it  does not exist");
                        return result;
                    }

                    AdditionalRequirements additionalRequirements = additionalRequirementsRepository.findById(Long.parseLong(companyDTO.getAdditionalRequirements()));
                    if (states != null) {
                        company.setAdditionalRequirements(additionalRequirements);
                    } else {
                        result.setMessage("Please provide a valid Additional Requirements name & it  does not exist");
                        return result;
                    }
                    companyRepository.save(company);
                    result.setSuccess(true);
                    result.setMessage(MessageResource.MESSAGE_UPDATE);
                } else {
                    result.setMessage("No Company Found");
                    return result;
                }
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
                result.setMessage(MessageResource.MESSAGE_DELETE);
                company.setStatus(false);
                companyRepository.save(company);
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
    public Result users(@Param("pageable") Pageable pageable, @RequestParam Map<String, String> queryParameters) {
        Result result = new Result();
        try {
            if (pageable == null)
                pageable = new PageRequest(0, 10);

            String query = queryParameters.get("query");
            Page<Company> page;
            if (query != null && query.trim().length() > 0) {
                page = companyRepository.findAllByStatusIsTrue(new CompanySpecification(query), pageable);
            } else {
                page = companyRepository.findAllByStatusIsTrue(pageable);
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

    @RequestMapping(value = "downloadCSV", method = RequestMethod.GET)
    public Result downloadCSV() {
        Result result = new Result();
        result.setSuccess(true);
        try {
            List<Company> company = companyRepository.findAll();


            if(company!=null){

            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }


}
