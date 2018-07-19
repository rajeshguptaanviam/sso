package com.eclipseeio.emi.rest;


import com.eclipseeio.emi.dto.AssignToDTO;
import com.eclipseeio.emi.model.AssignTo;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.AssignToRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class AssignToController {

    @Autowired
    AssignToRepository assignToRepository;


    @RequestMapping(method = RequestMethod.POST, value = "addAssignTo")
    public Result createAssignTo(@RequestBody AssignToDTO assignToDTO) {
        Result result = Validator.validateAssignTo(assignToDTO,assignToRepository);
        if (result.isSuccess()) {
            try {

                AssignTo assignTo=new AssignTo();
                assignTo.setAssignName(assignToDTO.getAssignName());
                assignTo.setActive(true);
                assignToRepository.save(assignTo);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_CREATE);
            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage(e.getMessage());
                e.printStackTrace();
            }
        }return result;
    }




    @RequestMapping(value = "deleteAssignTo/{id}", method = RequestMethod.DELETE)
    public Result deleteAssignTo(@PathVariable Long id) {
        Result result = new Result();
        try {
            AssignTo assignTo=assignToRepository.findById(id);
            if(assignTo != null) {
                if (assignTo.getActive().equals(true)) {
                    assignTo.setActive(false);
                    result.setSuccess(true);
                    result.setMessage(MessageResource.MESSAGE_DELETE);
                    assignToRepository.save(assignTo);
                }
                else {
                    result.setSuccess(true);
                    result.setMessage("Already deleted.."); }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }return result;
    }



    @RequestMapping(value = "getAssignTo", method = RequestMethod.GET)
    public Result getAssignTo() {
        Result result = new Result();
        try {
            List<AssignTo> assignToList=assignToRepository.findAllByActiveIsTrue();
            result.setAssignToList(assignToList);
            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }




    @RequestMapping(value = "getAssignToById/{id}", method = RequestMethod.GET)
    public Result getAssignToById(@PathVariable Long id) {
        Result result = new Result();
        try {

            AssignTo assignTo=assignToRepository.findByIdAndActiveIsTrue(id);

            if(assignTo!=null) {
                result.setAssignTo(assignTo);
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





    @RequestMapping(method = RequestMethod.PUT, value = "updateAssignTo/{id}")
    public Result updateAssignTo(@PathVariable Long id, @RequestBody AssignToDTO assignToDTO) {

        /*Result result = new Result();*/
        Result result = Validator.validateAssignTo(assignToDTO,assignToRepository);
        if (result.isSuccess()) {
            try {
                AssignTo assignTo = assignToRepository.findByIdAndActiveIsTrue(id);

                if (assignTo != null) {
                    assignTo.setAssignName(assignToDTO.getAssignName());
                    assignToRepository.save(assignTo);
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
