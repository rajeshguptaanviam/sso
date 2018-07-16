package com.eclipseeio.emi.rest;

import com.eclipseeio.emi.dto.IndustryDto;
import com.eclipseeio.emi.model.Industry;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.IndustryRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class IndustryController {


    @Autowired IndustryRepository industryRepository;

    @RequestMapping(method = RequestMethod.POST, value = "addIndustry")
    public Result createIndustry(@RequestBody IndustryDto industryDto) {
        Result result = Validator.validateIndustry(industryDto,industryRepository);
        if (result.isSuccess()) {
            try {
                Industry industry=new Industry();
                industry.setIndustryName(industryDto.getIndustryName());
                industry.setActive(true);
                industryRepository.save(industry);
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


    @RequestMapping(value = "deleteIndustry/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable Long id) {
        Result result = new Result();
        try {
            Industry industry=industryRepository.findByIdAndActive(id,true);
            if(industry != null) {
                if (industry.getActive().equals(true)) {
                    industry.setActive(false);
                    industryRepository.save(industry);
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



    @RequestMapping(value = "getIndustry", method = RequestMethod.GET)
    public Result getIndustry() {
        Result result = new Result();
        try {
            List<Industry> industries = industryRepository.findAllByActive(true);

            result.setIndustries(industries);
            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "getIndustrybyId/{id}", method = RequestMethod.GET)
    public Result getIndustryById(@PathVariable Long id) {
        Result result = new Result();
        try {
            Industry industries = industryRepository.findByIdAndActive(id,true);
            if(industries!=null) {
                result.setIndustry(industries);
                result.setSuccess(true);
            }else
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


    @RequestMapping(method = RequestMethod.PUT, value = "updateIndustry/{id}")
    public Result updateIndustry(@PathVariable Long id, @RequestBody IndustryDto industryDto) {
        Result result = new Result();

        try {
            Industry industries = industryRepository.findByIdAndActive(id,true);
            if(industries!=null) {
                industries.setIndustryName(industryDto.getIndustryName());
                industryRepository.save(industries);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_UPDATE);
            }else{
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