package com.eclipseeio.emi.service;

import com.eclipseeio.emi.dto.*;
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
        } else if (TextUtils.isEmpty(industryDto.getIndustryName())) {
            result.setMessage("Industery name is required*");
            result.setSuccess(false);
        }
        Industry industry = industryRepository.findByIndustryName(industryDto.getIndustryName());

        if (industry != null) {
            result.setMessage("Please try another industry name.It is already taken");
            result.setSuccess(false);
        }

        return result;
    }

    public static Result validateCallTopic(CallTopicDTO callTopicDTO,
                                           CallTopicRepository callTopicRepository) {
        Result result = new Result();
        result.setSuccess(true);
        if (callTopicDTO == null) {
            result.setMessage("no input params found");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(callTopicDTO.getCallTopicName())) {
            result.setMessage("call type name is required*");
            result.setSuccess(false);
        }
        CallTopic callTopic = callTopicRepository.findById(callTopicDTO.getId());

        if (callTopic != null) {
            result.setMessage("Please try another Call Topic  name.It is already taken");
            result.setSuccess(false);
        }

        return result;
    }

    public static Result validateDepartment(CompanyDepartmentDTO companyDepartmentDTO,
                                            CompanyDepartmentRepository companyDepartmentRepository) {
        Result result = new Result();
        result.setSuccess(true);
        if (companyDepartmentDTO == null) {
            result.setMessage("no input params found");
            result.setSuccess(false);
            return result;
        } else if (TextUtils.isEmpty(companyDepartmentDTO.getDepartmentName())) {
            result.setMessage("Department name is required*");
            result.setSuccess(false);
        }
        CompanyDepartment companyDepartment = companyDepartmentRepository.findByCompanyDepartmentName(companyDepartmentDTO.getDepartmentName());
        if (companyDepartment != null) {
            result.setMessage("Please try another department name.It is already taken");
            result.setSuccess(false);
            return result;
        }

        return result;
    }


    public static Result validateCompany(CompanyDTO companyDTO, CompanyRepository companyRepository,
                                         OrganizationsRepository organizationsRepository) {
        Result result = new Result();
        result.setSuccess(true);

        if (companyDTO.getOrganizationId() == null) {
            result.setMessage("Organization Id can not be Empty  and required*");
            result.setSuccess(false);
            return result;
        } else if (companyDTO == null) {
            result.setMessage("no input params found");
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
            Organizations _company = organizationsRepository.findById(companyDTO.getOrganizationId());
            if (_company == null) {
                result.setMessage("Please try another Organization id  does not exist");
                result.setSuccess(false);
                return result;
            }
        }
        if (result.isSuccess()) {
            Company _company = companyRepository.findByCompanyName(companyDTO.getCompanyName());
            if (_company != null) {
                result.setMessage("Please try another Company Name already taken ");
                result.setSuccess(false);
                return result;
            }
        }

        if (result.isSuccess()) {
            Company _company = companyRepository.findByEmail(companyDTO.getEmail());
            if (_company != null) {
                result.setMessage("Please try another Email  already taken ");
                result.setSuccess(false);
                return result;
            }
        }
        return result;
    }


    public static Result validateBenefits(BenefitsDto benefitsDto, BenefitsRepository benefitsRepository) {
        Result result = new Result();
        result.setSuccess(true);
        if (benefitsDto == null) {
            result.setMessage("no input params found.");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(benefitsDto.getBenefitsName())) {
            result.setMessage("Benefits name is required*");
            result.setSuccess(false);
        }

        Benefits benefits = benefitsRepository.findByBenefitsName(benefitsDto.getBenefitsName());

        if (benefits != null) {
            result.setMessage("Please try another benefits name.It is already taken");
            result.setSuccess(false);
        }

        return result;
    }


    public static Result validateStates(StatesDTO statesDTO, StatesRepository statesRepository) {
        Result result = new Result();
        result.setSuccess(true);
        if (statesDTO == null) {
            result.setMessage("no input params found.");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(statesDTO.getStateName())) {
            result.setMessage("State name is required*");
            result.setSuccess(false);
        }
        States states = statesRepository.findByStateName(statesDTO.getStateName());
        if (states != null) {
            result.setMessage("Please try another states name.It is already taken");
            result.setSuccess(false);
        }
        return result;
    }

    public static Result validateCallDetails(CallDetainsDTO callDetainsDTO, CompanyRepository companyRepository, UserRepository userRepository,CallTopicRepository callTopicRepository) {
        Result result = new Result();
        result.setSuccess(true);
        if (callDetainsDTO == null) {
            result.setMessage("no input params found.");
            result.setSuccess(false);
        } else if (callDetainsDTO.getCompanyId()== null) {
            result.setMessage("Company is required*");
            result.setSuccess(false);
        }else if(callDetainsDTO.getUserId()==null){
            result.setMessage("User is required*");
            result.setSuccess(false);
        }
        Company company = companyRepository.findById(callDetainsDTO.getCompanyId());
        if (company == null) {
            result.setMessage("Please try another company , does not exist");
            result.setSuccess(false);
        }

        User user = userRepository.findById(callDetainsDTO.getUserId());
        if (user == null) {
            result.setMessage("Please try another user , does not exist");
            result.setSuccess(false);
        }
        CallTopic callTopic = callTopicRepository.findById(callDetainsDTO.getCalltopicId());
        if (callTopic == null) {
            result.setMessage("Please try another call topic , does not exist");
            result.setSuccess(false);
        }
        return result;
    }


    public static Result validateAdditionalRequirements(AdditionalRequirementsDTO additionalRequirementsDTO, AdditionalRequirementsRepository additionalRequirementsRepository) {
        Result result = new Result();
        result.setSuccess(true);
        if (additionalRequirementsDTO == null) {
            result.setMessage("no input params found.");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(additionalRequirementsDTO.getAdditionalRequirementsName())) {
            result.setMessage("Additional Requirements name is required*");
            result.setSuccess(false);
        }
        AdditionalRequirements additionalRequirements = additionalRequirementsRepository.findByAdditionalRequirementsName(additionalRequirementsDTO.getAdditionalRequirementsName());
        if (additionalRequirements != null) {
            result.setMessage("Please try another Additional Requirements name.It is already taken");
            result.setSuccess(false);
        }
        return result;
    }


    public static Result validateAssignTo(AssignToDTO assignToDTO, AssignToRepository assignToRepository) {
        Result result = new Result();
        result.setSuccess(true);
        if (assignToDTO == null) {
            result.setMessage("no input params found.");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(assignToDTO.getAssignName())) {
            result.setMessage("AssignTo name is required*");
            result.setSuccess(false);
        }
        AssignTo assignTo = assignToRepository.findByAssignName(assignToDTO.getAssignName());
        if (assignTo != null) {
            result.setMessage("Please try another AssignTo name.It is already taken");
            result.setSuccess(false);
        }
        return result;
    }


    public static Result validatePolicies(PoliciesDTO policiesDTO, PoliciesRepository policiesRepository) {
        Result result = new Result();
        result.setSuccess(true);
        if (policiesDTO == null) {
            result.setMessage("no input params found.");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(policiesDTO.getPoliciesName())) {
            result.setMessage("Policies name is required*");
            result.setSuccess(false);
        }
        Policies policies = policiesRepository.findByPoliciesName(policiesDTO.getPoliciesName());
        if (policies != null) {
            result.setMessage("Please try another policies name.It is already taken");
            result.setSuccess(false);
        }
        return result;
    }




}
