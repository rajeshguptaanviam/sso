package com.eclipseeio.emi.rest;


import com.eclipseeio.emi.dto.StatesDTO;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.model.States;
import com.eclipseeio.emi.repository.StatesRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/")
public class StatesController {

    @Autowired
    StatesRepository statesRepository;


    @RequestMapping(method = RequestMethod.POST, value = "addStates")
    public Result createStates(@RequestBody StatesDTO statesDTO) {
        Result result = Validator.validateStates(statesDTO,statesRepository);
        if (result.isSuccess()) {
            try {
                States states=new States();
                states.setStateName(statesDTO.getStateName());
                states.setActive(true);
                statesRepository.save(states);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_CREATE);
            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage(e.getMessage());
                e.printStackTrace();
            }
        }return result;
    }


    @RequestMapping(value = "deleteStates/{id}", method = RequestMethod.DELETE)
    public Result deleteStatesById(@PathVariable Long id) {
        Result result = new Result();
        try {
            States states=statesRepository.findByIdAndActive(id,true);
            if(states !=null) {
                if (states.getActive().equals(true)) {
                    states.setActive(false);
                    result.setMessage(MessageResource.MESSAGE_DELETE);
                    statesRepository.save(states);
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
        return result; }


    @RequestMapping(value = "getStates", method = RequestMethod.GET)
    public Result getStates() {
        Result result = new Result();
        try {
            List<States> states = statesRepository.findAllByActive(true);
            result.setStates(states);
            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "getStatesById/{id}", method = RequestMethod.GET)
    public Result getStatesById(@PathVariable Long id) {
        Result result = new Result();
        try {
            States states=statesRepository.findByIdAndActive(id,true);
            if(states!=null) {
                result.set_states(states);
                result.setSuccess(true); }
            else
            {
                result.setMessage("no data found"); }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace(); }
        return result;
    }



    @RequestMapping(method = RequestMethod.PUT, value = "updateStates/{id}")
    public Result updateStates(@PathVariable Long id, @RequestBody StatesDTO statesDTO) {

        Result result = new Result();
        try {


            States states=statesRepository.findByIdAndActive(id,true);

            if(states!=null) {
                states.setStateName(statesDTO.getStateName());
                statesRepository.save(states);
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
