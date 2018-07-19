package com.eclipseeio.emi.rest;


import com.eclipseeio.emi.dto.PerformanceReviewDTO;
import com.eclipseeio.emi.model.AssignTo;
import com.eclipseeio.emi.model.PerformanceReview;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.repository.PerformanceReviewRepository;
import com.eclipseeio.emi.service.MessageResource;
import com.eclipseeio.emi.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class PerformanceReviewController {

    @Autowired
    PerformanceReviewRepository performanceReviewRepository;


    @RequestMapping(method = RequestMethod.POST, value = "addPerformanceReview")
    public Result createPerformanceReview(@RequestBody PerformanceReviewDTO performanceReviewDTO) {
        Result result = Validator.validatePerformanceReview(performanceReviewDTO,performanceReviewRepository);
        if (result.isSuccess()) {
            try {

                PerformanceReview performanceReview=new PerformanceReview();
                performanceReview.setPerformanceReviewName(performanceReviewDTO.getPerformanceReviewName());
                performanceReview.setActive(true);
                performanceReviewRepository.save(performanceReview);
                result.setSuccess(true);
                result.setMessage(MessageResource.MESSAGE_CREATE);
            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage(e.getMessage());
                e.printStackTrace();
            }
        }return result; }



    @RequestMapping(value = "deletePerformanceReview/{id}", method = RequestMethod.DELETE)
    public Result deletePerformanceReview(@PathVariable Long id) {
        Result result = new Result();
        try {
            PerformanceReview performanceReview=performanceReviewRepository.findById(id);
            if(performanceReview != null) {
                if (performanceReview.getActive().equals(true)) {
                   performanceReview.setActive(false);
                    result.setMessage(MessageResource.MESSAGE_DELETE);
                    result.setSuccess(true);
                    performanceReviewRepository.save(performanceReview);
                }

                else {
                    result.setSuccess(true);
                    result.setMessage("Allready Deleted...."); }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }return result;
    }







    @RequestMapping(value = "getPerformanceReview", method = RequestMethod.GET)
    public Result getPerformanceReview() {

        Result result = new Result();
        try {
            List<PerformanceReview> performanceReviewList=performanceReviewRepository.findAllByActiveIsTrue();
         result.setPerformanceReviewList(performanceReviewList);

            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }



    @RequestMapping(value = "getPerformanceReviewById/{id}", method = RequestMethod.GET)
    public Result getPerformanceReviewById(@PathVariable Long id) {
        Result result = new Result();
        try {
            PerformanceReview performanceReview=performanceReviewRepository.findByIdAndActiveIsTrue(id);
            if(performanceReview!=null) {
                result.setPerformanceReview(performanceReview);
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


    @RequestMapping(method = RequestMethod.PUT, value = "updatePerformanceReview/{id}")
    public Result updatePerformanceReview(@PathVariable Long id, @RequestBody PerformanceReviewDTO performanceReviewDTO) {
        Result result = Validator.validatePerformanceReview(performanceReviewDTO,performanceReviewRepository);
        if (result.isSuccess()) {
           /* Result result = new Result();*/
            try {
                PerformanceReview performanceReview = performanceReviewRepository.findByIdAndActiveIsTrue(id);

                if (performanceReview != null) {
                    performanceReview.setPerformanceReviewName(performanceReviewDTO.getPerformanceReviewName());
                    performanceReviewRepository.save(performanceReview);
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
