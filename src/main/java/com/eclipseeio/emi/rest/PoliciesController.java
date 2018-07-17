package com.eclipseeio.emi.rest;


import com.eclipseeio.emi.dto.PoliciesDTO;
import com.eclipseeio.emi.model.Policies;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.PoliciesRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/")
public class PoliciesController {

    @Autowired
    PoliciesRepository policiesRepository;


    @RequestMapping(method = RequestMethod.POST, value = "addPolicies")
    public Result createPolicies(@RequestBody PoliciesDTO policiesDTO) {
        Result result = Validator.validatePolicies(policiesDTO,policiesRepository);
        if (result.isSuccess()) {
            try {
                Policies policies=new Policies();
                policies.setPoliciesName(policiesDTO.getPoliciesName());
                policies.setActive(true);
                policiesRepository.save(policies);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_CREATE);
            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage(e.getMessage());
                e.printStackTrace();
            }
        }return result;
    }




    @RequestMapping(value = "deletePolicies/{id}", method = RequestMethod.DELETE)
    public Result deletePolicies(@PathVariable Long id) {
        Result result = new Result();
        try {
            Policies policies=policiesRepository.findByIdAndActiveIsTrue(id);
            if(policies != null) {
                if (policies.getActive().equals(true)) {
                  policies.setActive(false);
                    result.setMessage(MessageResource.MESSAGE_DELETE);
                    policiesRepository.save(policies);
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


    @RequestMapping(value = "getPolicies", method = RequestMethod.GET)
    public Result getPolicies() {
        Result result = new Result();
        try {
            List<Policies> policiesList=policiesRepository.findAllByActiveIsTrue();
            result.setPoliciesList(policiesList);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "getPoliciesById/{id}", method = RequestMethod.GET)
    public Result getPoliciesById(@PathVariable Long id) {
        Result result = new Result();
        try {
            Policies policies=policiesRepository.findByIdAndActiveIsTrue(id);
            if(policies!=null) {
                result.setPolicies(policies);
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






    @RequestMapping(method = RequestMethod.PUT, value = "updatePolicies/{id}")
    public Result updatePolicies(@PathVariable Long id, @RequestBody PoliciesDTO policiesDTO) {
        Result result = new Result();
        try {
            Policies policies=policiesRepository.findByIdAndActiveIsTrue(id);

            if(policies!=null) {
                policies.setPoliciesName(policiesDTO.getPoliciesName());
                policiesRepository.save(policies);
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
