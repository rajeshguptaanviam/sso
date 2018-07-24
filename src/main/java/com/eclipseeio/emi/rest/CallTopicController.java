package com.eclipseeio.emi.rest;

import com.eclipseeio.emi.dto.CallTopicDTO;
import com.eclipseeio.emi.model.CallTopic;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.CallTopicRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class CallTopicController {
    @Autowired
    private CallTopicRepository callTopicRepository;

    @RequestMapping(method = RequestMethod.POST, value = "addcallTopic")
    public Result createIndustry(@RequestBody CallTopicDTO callTopicDTO) {
        Result result = Validator.validateCallTopic(callTopicDTO, callTopicRepository);
        if (result.isSuccess()) {
            try {
                CallTopic callTopic = new CallTopic();
                callTopic.setCallTopicName(callTopicDTO.getCallTopicName());
                callTopic.setActive(true);
                callTopicRepository.save(callTopic);
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


    @RequestMapping(value = "deleteCallTopic/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable Long id) {
        Result result = new Result();
        try {
            CallTopic callTopic = callTopicRepository.findById(id);
            if (callTopic != null) {

                if (callTopic.getActive().equals(true)) {
                    callTopic.setActive(false);
                    callTopicRepository.save(callTopic);
                    result.setSuccess(true);
                    result.setMessage(MessageResource.MESSAGE_DELETE);
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


    @RequestMapping(value = "getCallTopic", method = RequestMethod.GET)
    public Result getIndustry() {
        Result result = new Result();
        try {
            List<CallTopic> callTopics = callTopicRepository.findAllByActiveIsTrue();
            result.setCallTopics(callTopics);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "getcalltopic/{id}", method = RequestMethod.GET)
    public Result getIndustryById(@PathVariable Long id) {
        Result result = new Result();
        try {
            CallTopic callTopic = callTopicRepository.findByIdAndActiveIsTrue(id);
            if (callTopic != null) {
                result.setCallTopic(callTopic);
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


    @RequestMapping(method = RequestMethod.PUT, value = "updateCallTopic/{id}")
    public Result updateIndustry(@PathVariable Long id, @RequestBody CallTopicDTO callTopicDTO) {
   /*     Result result = new Result();*/

        Result result = Validator.validateCallTopic(callTopicDTO, callTopicRepository);
        if (result.isSuccess()) {
            try {
                CallTopic callTopic = callTopicRepository.findByIdAndActiveIsTrue(id);
                if (callTopic != null) {
                    callTopic.setCallTopicName(callTopicDTO.getCallTopicName());
                    callTopicRepository.save(callTopic);
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

        }
        return result;
    }


}