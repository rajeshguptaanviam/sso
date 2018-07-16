package com.eclipseeio.emi.rest;


import com.eclipseeio.emi.dto.AdditionalRequirementsDTO;
import com.eclipseeio.emi.model.AdditionalRequirements;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.AdditionalRequirementsRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/")
public class AdditionalRequirementsController {

    @Autowired
    AdditionalRequirementsRepository additionalRequirementsRepository;


    @RequestMapping(method = RequestMethod.POST, value = "addAdditionalRequirements")
    public Result createAdditionalRequirements(@RequestBody AdditionalRequirementsDTO additionalRequirementsDTO) {
        Result result = Validator.validateAdditionalRequirements(additionalRequirementsDTO,additionalRequirementsRepository);
        if (result.isSuccess()) {
            try {
                AdditionalRequirements additionalRequirements=new AdditionalRequirements();
                additionalRequirements.setAdditionalRequirementsName(additionalRequirementsDTO.getAdditionalRequirementsName());
                additionalRequirements.setActive(true);
                additionalRequirementsRepository.save(additionalRequirements);

                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_CREATE);
            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage(e.getMessage());
                e.printStackTrace();
            }
        }return result;
    }





    @RequestMapping(value = "deleteAdditionalRequirements/{id}", method = RequestMethod.DELETE)
    public Result deleteAdditionalRequirements(@PathVariable Long id) {
        Result result = new Result();
        try {
            AdditionalRequirements additionalRequirements=additionalRequirementsRepository.findByIdAndActiveIsTrue(id);
            if(additionalRequirements != null) {
                if (additionalRequirements.getActive().equals(true)) {
                    additionalRequirements.setActive(false);
                    result.setMessage(MessageResource.MESSAGE_DELETE);
                    additionalRequirementsRepository.save(additionalRequirements);
                }
                else {
                    result.setSuccess(true);
                    result.setMessage(MessageResource.MESSAGE_DELETE); }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }return result;
    }



    @RequestMapping(value = "getAdditionalRequiremnts", method = RequestMethod.GET)
    public Result getAdditionalRequirements() {
        Result result = new Result();
        try {
            List<AdditionalRequirements> additionalRequirementsList=additionalRequirementsRepository.findAllByActiveIsTrue();
            result.setAdditionalRequirementsList(additionalRequirementsList);
            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }



    @RequestMapping(value = "getAdditionalRequirementsById/{id}", method = RequestMethod.GET)
    public Result getAdditionalRequirementsById(@PathVariable Long id) {
        Result result = new Result();
        try {
            AdditionalRequirements additionalRequirements=additionalRequirementsRepository.findByIdAndActiveIsTrue(id);

            if(additionalRequirements!=null) {
                result.setAdditionalRequirements(additionalRequirements);
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



    @RequestMapping(method = RequestMethod.PUT, value = "updateAdditionalRequirements/{id}")
    public Result updateAdditionalRequirements(@PathVariable Long id, @RequestBody AdditionalRequirementsDTO additionalRequirementsDTO) {

        Result result = new Result();
        try {

            AdditionalRequirements additionalRequirements=additionalRequirementsRepository.findByIdAndActiveIsTrue(id);

            if(additionalRequirements!=null) {
                additionalRequirements.setAdditionalRequirementsName(additionalRequirementsDTO.getAdditionalRequirementsName());
                additionalRequirementsRepository.save(additionalRequirements);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_UPDATE);
            }
            else{
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
