package com.emi.hremi.rest;


import com.emi.hremi.constant.Status;
import com.emi.hremi.dto.ChangePasswordDTO;
import com.emi.hremi.dto.LoginDTO;
import com.emi.hremi.model.LoginSecureInfo;
import com.emi.hremi.model.log.LogLoginSecureInfo;
import com.emi.hremi.model.response.Result;
import com.emi.hremi.repository.LoginSecureRepository;
import com.emi.hremi.repository.logRepositorty.LogLoginSecureRepository;
import com.emi.hremi.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@RestController
public class LoginSecureInfoController {
    @Autowired
    LoginSecureRepository loginSecureRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    LogLoginSecureRepository logLoginSecureRepository;
    //@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${app.url}")
    private String aUrl;


    /**
     * In this api you can register end user .
     * loginSecureInfo is property bean
     * @param loginSecureInfo
     * @return
     */
    @RequestMapping(name = "/signUp",method = RequestMethod.POST)
    public Result signUp(@Valid  @RequestBody LoginSecureInfo loginSecureInfo){
        Result result = new Result();
        try {
            LoginSecureInfo _loginSecureInfo = loginSecureRepository.findByEmail(loginSecureInfo.getEmail());
            if(_loginSecureInfo!=null){
                result.setMessage("email is already exist");
                return result;
            }
            LoginSecureInfo loginSecureInfo_ = loginSecureRepository.findByUsername(loginSecureInfo.getUsername());
            if(loginSecureInfo_ !=null){
                result.setMessage("User name is already exist");
                return  result;
            }
            LoginSecureInfo loginSecureInfoCompanyName = loginSecureRepository.findByCompanyName(loginSecureInfo.getCompanyName());
            if(loginSecureInfoCompanyName !=null){
                result.setMessage("Company name is already exist");
                return  result;
            }
            loginSecureRepository.save(loginSecureInfo);
            result.setSuccess(true);
            result.setMessage("created successfully");

        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /*============================================Encoding=================================================================*/
    //Encoding
/*
                byte[] message = "hello world".getBytes("UTF-8");
                String encoded = DatatypeConverter.printBase64Binary(message);
                System.out.println(encoded);
*/
 // Decoding

/*
                byte[] decoded = DatatypeConverter.parseBase64Binary("aGVsbG8gd29ybGQ=");
                System.out.println(new String(decoded, "UTF-8"));
                // => hello world
                  Instant first = Instant.now();
                // wait some time while something happens
                    Instant second = Instant.now();
                     Duration duration = Duration.between(first, second);*/

    /*=============================================Decoding================================================================*/






    /**
     * forgot password : you can change your password
     * email param : you can  provide your valid email address if email address is not valid
     * response status will be false and mail not sent message
     * @param email
     * @return
     */

    @RequestMapping(value = "/forgotPassword",method = RequestMethod.POST)
    public Result forgotPassword(@RequestParam String  email){
        Result result = new Result();
        try {
            if(email!=null){
                LoginSecureInfo loginSecureInfo = loginSecureRepository.findByEmail(email);
                if(loginSecureInfo != null){
                    byte[] message_= email.getBytes(StandardCharsets.UTF_8);
                    Instant instant = Instant.now();
                    Long timeStampMillis = instant.toEpochMilli();
                    System.out.println(timeStampMillis.toString());
                    byte[] value_= timeStampMillis.toString().getBytes(StandardCharsets.UTF_8);
                    String encoded = DatatypeConverter.printBase64Binary(message_);
                    String value = DatatypeConverter.printBase64Binary(value_);
                    System.out.println(timeStampMillis);
                    String url = aUrl + "/resetPassword?token="+encoded+"&value="+value;
                    String message = "Click here to change new password <a href="+url+">Change Password</a>";
                    emailService.sendHtmlMail(loginSecureInfo.getEmail(),"Forgot Password",message);
                    Timestamp ts=new Timestamp(timeStampMillis);
                    Date date=new Date(ts.getTime());
                    loginSecureInfo.setLastPasswordUpdate(date);
                    loginSecureRepository.save(loginSecureInfo);
                    result.setSuccess(true);
                    result.setMessage("Mail Sent");
                }else{
                    result.setSuccess(false);
                    result.setMessage("your email address Not register");
                }
            }else {
                result.setSuccess(false);
                result.setMessage("your email address Not register");
            }
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    /**
     * In this api you can check email url(sent mail forgot url) is valid or not
     * if valid got a forgot password valid url
     *
     * @param request
     * @return
     */

    @RequestMapping(value = "/validateEmailLink",method = RequestMethod.GET)
    public Result resetPassword(HttpServletRequest request){
        Result result = new Result();
        result.setSuccess(true);
        try {
            String token =request.getParameter("token");
            String value = request.getParameter("value");
            byte[] decoded = DatatypeConverter.parseBase64Binary(token);
            String email = new String(decoded, "UTF-8");
            LoginSecureInfo loginSecureInfo = loginSecureRepository.findByEmail(email);
            Date date = loginSecureInfo.getLastPasswordUpdate();
            Instant instant = Instant.now();
            Duration duration = Duration.between(date.toInstant(),instant);
            long mint = duration.toMinutes();
            if(mint < 30){
                String url = aUrl + "/resetPassword?token="+token+"&value="+value;
                result.setForgetPasswordLink(url);
                result.setSuccess(true);
            }else {
                result.setSuccess(false);
                result.setMessage("Forgot password link has expired");
            }
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * In this api you can reset you password
     * changePasswordDTO bean property
     * @param request
     * @param changePasswordDTO
     * @return
     */

    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    public Result resetPassword(HttpServletRequest request,@RequestBody ChangePasswordDTO changePasswordDTO){
        Result result = new Result();
        result.setSuccess(true);
        try {
           String token =request.getParameter("token");
           String value = request.getParameter("value");
            byte[] decoded = DatatypeConverter.parseBase64Binary(token);
            String email = new String(decoded, "UTF-8");
            LoginSecureInfo loginSecureInfo = loginSecureRepository.findByEmail(email);
                Date date = loginSecureInfo.getLastPasswordUpdate();
                Instant instant = Instant.now();
                Duration duration = Duration.between(date.toInstant(),instant);
                long mint = duration.toMinutes();
                if(mint < 30){
                    if(changePasswordDTO != null){
                        if(changePasswordDTO.getPassword().equals(changePasswordDTO.getConfirmPassword())){
                            loginSecureInfo.setPassword(changePasswordDTO.getPassword());
                            loginSecureRepository.save(loginSecureInfo);
                            result.setMessage("successfully reset password");
                        }else{
                            result.setSuccess(false);
                            result.setMessage("Please provide me same password");
                        }
                    }
                }else {

                    result.setSuccess(false);
                    result.setMessage("Forgot password link has expired");
                }
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * In you can update your old password to new password
     *
     * @param changePasswordDTO
     * @param request
     * @return
     */
    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    public Result changePassword(@RequestBody ChangePasswordDTO changePasswordDTO,HttpServletRequest request){
        Result result = new Result();
        result.setSuccess(true);
        try {
            HttpSession session = request.getSession(false);
             if(session !=null) {
                String token = (String) session.getAttribute("token");
                byte[] decoded = DatatypeConverter.parseBase64Binary(token);
                String email = new String(decoded, "UTF-8");
                LoginSecureInfo loginSecureInfo = loginSecureRepository.findByEmail(email);
                if(loginSecureInfo!=null){
                    if(changePasswordDTO!=null) {
                        if(!changePasswordDTO.getOldPassword().equals("") && changePasswordDTO.getOldPassword() != null && !changePasswordDTO.getNewPassword().equals("") && changePasswordDTO.getNewPassword() != null &&
                                changePasswordDTO.getOldPassword().trim().length()!=0  && changePasswordDTO.getNewPassword().trim().length()!=0){
                            if (!loginSecureInfo.getPassword().equals(changePasswordDTO.getOldPassword())) {
                                result.setMessage("Plesae provide me correct password");
                                result.setSuccess(false);
                                return result;

                            } else {
                                        loginSecureInfo.setPassword(changePasswordDTO.getNewPassword());
                                        loginSecureRepository.save(loginSecureInfo);
                                        result.setMessage("successfully change password");
                                        result.setSuccess(true);
                                        return result;
                            }

                        }
                    }
                }
             }else {

                result.setSuccess(false);
                result.setMessage("Internal server Error");

             }
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * in this api you can logouts
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public Result logout(HttpServletRequest request){
        Result result = new Result();
        try {
            result.setSuccess(true);
            HttpSession httpSession = request.getSession(false);
            if(httpSession!=null) {
                LogLoginSecureInfo logLoginSecureInfo = new LogLoginSecureInfo();
                logLoginSecureInfo.setLoginStatus(Status.LOGOUT.name());
                logLoginSecureInfo.setLoginMessage(Status.LOGOUT.name());
                logLoginSecureRepository.save(logLoginSecureInfo);
                httpSession.invalidate();
                result.setMessage("successfully logout");
            }else{
                result.setSuccess(false);
                result.setMessage("Internal server Error");
            }
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * In this api you can login in your application.
     * @param loginDTO
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response){
        Result result = new Result();
        try {
            result.setSuccess(true);
            if(loginDTO != null){
                if(loginDTO.getUsername() != null && !(loginDTO.getUsername().equals("")) && loginDTO.getUsername().trim().length() != 0){
                    LoginSecureInfo loginSecureInfo=loginSecureRepository.findByUsername(loginDTO.getUsername());
                    if(loginSecureInfo!=null){
                        HttpSession httpSession=request.getSession();
                        if(loginSecureInfo.getPassword().equals(loginDTO.getPassword())){
                            byte[] value_= loginSecureInfo.getEmail().getBytes(StandardCharsets.UTF_8);
                            String encoded = DatatypeConverter.printBase64Binary(value_);
                            httpSession.setAttribute("token",encoded);
                            response.setHeader("token",encoded);
                            if(loginDTO.getTargetUrl()!=null && !loginDTO.getTargetUrl().equals("")){
                                result.setTargetUrl(loginDTO.getTargetUrl());
                            }else{
                                result.setMessage("Target Url Mandatory");
                                result.setSuccess(false);
                                return result;
                            }
                            response.sendRedirect(loginDTO.getTargetUrl());
                            int responseStatus=response.getStatus();
                            //result.setTargetUrl(loginSecureInfo.getTargetUrl());
                            result.setMessage("successfully login");
                        }else if(!(loginSecureInfo.getUsername().equals(loginDTO.getUsername()))){
                            result.setSuccess(false);
                            result.setMessage("Username Invalid");
                        }else{
                            result.setSuccess(false);
                            result.setMessage("Password Invalid");
                        }
                    }else{
                        result.setSuccess(false);
                        result.setMessage("Username & password are invalid");
                    }
                }else{

                    result.setSuccess(false);
                    result.setMessage("Username can not be empty");
                }
            }
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(false);
        }
        return result;
    }






}
