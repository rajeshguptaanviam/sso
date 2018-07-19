package com.eclipseeio.emi.rest;


import com.eclipseeio.emi.dto.BenefitsDto;
import com.eclipseeio.emi.model.Benefits;
import com.eclipseeio.emi.model.Industry;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.BenefitsRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/")
public class BenefitsController {

    @Autowired  private BenefitsRepository benefitsRepository;


    @RequestMapping(method = RequestMethod.POST, value = "addBenefits")
    public Result createBenefits(@RequestBody BenefitsDto benefitsDto) {
        Result result = Validator.validateBenefits(benefitsDto,benefitsRepository);
        if (result.isSuccess()) {
            try {

                Benefits benefits=new Benefits();
                benefits.setBenefitsName(benefitsDto.getBenefitsName());
                benefits.setActive(true);
                benefitsRepository.save(benefits);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_CREATE);
            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage(e.getMessage());
                e.printStackTrace();
            }
        }return result;
    }



    @RequestMapping(value = "deleteBenefits/{id}", method = RequestMethod.DELETE)
    public Result deleteBenefits(@PathVariable Long id) {
        Result result = new Result();
        try {
            Benefits benefits=benefitsRepository.findById(id);
            if(benefits != null) {
                if (benefits.getActive().equals(true)) {
                    benefits.setActive(false);
                    result.setMessage(MessageResource.MESSAGE_DELETE);
                    result.setSuccess(true);
                    benefitsRepository.save(benefits);
                } else {
                    result.setSuccess(true);
                    result.setMessage("Already deleted..");
                }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }



    @RequestMapping(value = "getBenefits", method = RequestMethod.GET)
    public Result getBenefits() {
        Result result = new Result();
        try {
            List<Benefits> benefits = benefitsRepository.findAllByActive(true);
            result.setBenefits(benefits);
            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }



    @RequestMapping(value = "getBenefitsById/{id}", method = RequestMethod.GET)
    public Result getIndustryById(@PathVariable Long id) {
        Result result = new Result();
        try {
            Benefits benefits=benefitsRepository.findByIdAndActive(id,true);

            if(benefits!=null) {
                result.set_benefits(benefits);
                result.setSuccess(true);
            }
            else
            {
                result.setMessage("no data found");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }




    @RequestMapping(method = RequestMethod.PUT, value = "updateBenifites/{id}")
    public Result updateBenefits(@PathVariable Long id, @RequestBody BenefitsDto benefitsDto) {

    /*    Result result = new Result();*/
        Result result = Validator.validateBenefits(benefitsDto,benefitsRepository);
        if (result.isSuccess()) {
            try {

                Benefits benefits = benefitsRepository.findByIdAndActive(id, true);

                if (benefits != null) {
                    benefits.setBenefitsName(benefitsDto.getBenefitsName());
                    benefitsRepository.save(benefits);
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
        }return result;
    }


}
