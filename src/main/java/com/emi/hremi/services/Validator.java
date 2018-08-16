package com.emi.hremi.services;

import com.emi.hremi.dto.LoginSecureInfoDTO;
import com.emi.hremi.model.response.Result;
import com.emi.hremi.repository.LoginSecureRepository;

public class Validator {




    public static Result loginSecureValidater(LoginSecureRepository loginSecureRepository
            , LoginSecureInfoDTO loginSecureInfoDTO){
                EmailValidator emailValidator = new EmailValidator();
                Result result = new Result();
                result.setSuccess(true);
            if(loginSecureInfoDTO == null){
                result.setMessage("information can not be null");

            }else if(TextUtils.valid(loginSecureInfoDTO.getEmail()) && emailValidator.validateEmail(loginSecureInfoDTO.getEmail()) ){
                result.setMessage("Please provide valid email address and not empty");
                result.setSuccess(false);

            }else if(TextUtils.valid(loginSecureInfoDTO.getCompanyName())){
                        result.setMessage("company name is required*");
                        result.setSuccess(false);

            }else if(TextUtils.valid(loginSecureInfoDTO.getUsername()) && loginSecureInfoDTO.getUsername().length() > 4){

                result.setMessage("username is required* & more than 4 char.");
                result.setSuccess(false);

            }


        return result;
    }





}
