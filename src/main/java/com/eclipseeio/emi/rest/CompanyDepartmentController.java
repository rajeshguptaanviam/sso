package com.eclipseeio.emi.rest;

import com.eclipseeio.emi.dto.CompanyDepartmentDTO;
import com.eclipseeio.emi.dto.IndustryDto;
import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.CompanyDepartment;
import com.eclipseeio.emi.model.Industry;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.CompanyDepartmentRepository;
import com.eclipseeio.emi.repository.CompanyRepository;
import com.eclipseeio.emi.repository.IndustryRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class CompanyDepartmentController {


    @Autowired
    private CompanyDepartmentRepository companyDepartmentRepository;
    @Autowired CompanyRepository companyRepository;

    @RequestMapping(method = RequestMethod.POST, value = "addDepatment")
    public Result createDepartment(@RequestBody CompanyDepartmentDTO companyDepartmentDTO) {
        Result result = Validator.validateDepartment(companyDepartmentDTO,companyDepartmentRepository);
        Company company=companyRepository.findById(companyDepartmentDTO.getCompanyId());
        if(company!=null){
        if (result.isSuccess()) {
            try {
                CompanyDepartment companyDepartment = new CompanyDepartment();
                companyDepartment.setCompanyDepartmentName(companyDepartmentDTO.getDepartmentName());
                companyDepartment.setCompany(company);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_CREATE);
                return result;
            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage(e.getMessage());
                e.printStackTrace();
            }
        }
        }else {
            result.setSuccess(false);
            result.setMessage("Company not found Please provide vaild company name & company does not exist");
        }
        return result;
    }


    @RequestMapping(value = "deleteDepartment/{id}", method = RequestMethod.DELETE)
    public Result deleteDepartment(@PathVariable Long id) {
        Result result = new Result();
        try {
            CompanyDepartment companyDepartment = companyDepartmentRepository.findByIdAndStatusIsTrue(id);
            if (companyDepartment != null) {
                if (companyDepartment.getStatus()==true) {
                    companyDepartment.setStatus(false);
                    companyDepartmentRepository.save(companyDepartment);
                    return result;
                } else {
                    result.setSuccess(true);
                    result.setMessage(MessageResource.MESSAGE_DELETE);
                    return result;
                }
            }

        } catch (Exception e) {

            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }



    @RequestMapping(value = "departments", method = RequestMethod.GET)
    public Result getIndustry() {
        Result result = new Result();
        try {
            List<CompanyDepartment> companyDepartments = companyDepartmentRepository.findAllByStatusIsTrue();
            result.setCompanyDepartments(companyDepartments);
            result.setSuccess(true);
            return result;

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "department/{id}", method = RequestMethod.GET)
    public Result department(@PathVariable Long id) {
        Result result = new Result();
        try {
            CompanyDepartment companyDepartment = companyDepartmentRepository.findByIdAndStatusIsTrue(id);
            if(companyDepartment!=null) {
                result.setCompanyDepartment(companyDepartment);
                result.setSuccess(true);
                return result;
            }else
            {
                result.setMessage("no data found");
                return result;
            }

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(method = RequestMethod.PUT, value = "updateDepartment/{id}")
    public Result updateIndustry(@PathVariable Long id, @RequestBody CompanyDepartmentDTO companyDepartmentDTO) {
        Result result = new Result();

        try {
            CompanyDepartment companyDepartment = companyDepartmentRepository.findByIdAndStatusIsTrue(id);
            if(companyDepartment!=null) {
                if(!companyDepartment.getCompanyDepartmentName().equalsIgnoreCase(companyDepartmentDTO.getDepartmentName())){
                    companyDepartment.setCompanyDepartmentName(companyDepartmentDTO.getDepartmentName());
                }
                companyDepartmentRepository.save(companyDepartment);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_UPDATE);
                return result;
            }else{
                result.setMessage(MessageResource.MESSAGE_DATA_NOT_FOUND);
                return result;
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