package com.emi.hremi.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class ChangePasswordDTO {
    private String oldPassword;
    private String newPassword;
    @NotEmpty(message = "password can not be empty")
    @NotNull(message = "password can not be null")
    private String password;
    @NotEmpty(message = "confirm password can not be empty")
    @NotNull(message = "confirm password can not be null")
    private String confirmPassword;



    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
