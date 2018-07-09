package com.eclipseeio.emi.service;


import com.eclipseeio.emi.dto.UserDto;
import com.eclipseeio.emi.model.Result;
import com.eclipseeio.emi.model.User;
import com.eclipseeio.emi.repository.UserRepository;
public class Validator {

    /**
     * @param user
     * @param userRepository
     * @return
     */
    public static Result validateNewUser(UserDto user, UserRepository userRepository) {
        Result result = new Result();
        result.setSuccess(true);
        if (user == null) {
            result.setMessage("no input params found");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(user.getFirstname())) {
            result.setMessage("firstname is required*");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(user.getLastname())) {
            result.setMessage("lastname is required*");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(user.getEmail())) {
            result.setMessage("email is required*");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(user.getUsername())) {
            result.setMessage("username is required*");
            result.setSuccess(false);
        } else if (user.getUsername().length() < 4) {
            result.setMessage("username must be between 4 and 100");
            result.setSuccess(false);
        } else if (TextUtils.isEmpty(user.getPassword())) {
            result.setMessage("password is required*");
            result.setSuccess(false);
        } else if (user.getPassword().length() < 4) {
            result.setMessage("password must be between 4 and 100");
            result.setSuccess(false);
        }
        if (result.isSuccess()) {
            User _user = userRepository.findByUsername(user.getUsername());
            if (_user != null) {
                result.setMessage("Please try another username its already taken");
                result.setSuccess(false);
            }
        }

        if (result.isSuccess()) {
            User _user = userRepository.findByEmail(user.getEmail());
            if (_user != null) {
                result.setMessage("Please try another email its already taken");
                result.setSuccess(false);
            }
        }

        return result;
    }



}
