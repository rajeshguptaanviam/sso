package com.emi.hremi.model.response;

import com.emi.hremi.model.LoginSecureInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    private Integer responseStatus;
    private boolean isSuccess;
    private String message;
    private String forgetPasswordLink;
    private String targetUrl;

    LoginSecureInfo loginSecureInfo;
    List<LoginSecureInfo> loginSecureInfoList;

    public LoginSecureInfo getLoginSecureInfo() {
        return loginSecureInfo;
    }

    public void setLoginSecureInfo(LoginSecureInfo loginSecureInfo) {
        this.loginSecureInfo = loginSecureInfo;
    }

    public List<LoginSecureInfo> getLoginSecureInfoList() {
        return loginSecureInfoList;
    }

    public void setLoginSecureInfoList(List<LoginSecureInfo> loginSecureInfoList) {
        this.loginSecureInfoList = loginSecureInfoList;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getForgetPasswordLink() {
        return forgetPasswordLink;
    }

    public void setForgetPasswordLink(String forgetPasswordLink) {
        this.forgetPasswordLink = forgetPasswordLink;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Integer getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }
}
