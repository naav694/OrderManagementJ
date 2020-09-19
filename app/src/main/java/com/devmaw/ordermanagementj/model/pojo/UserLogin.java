package com.devmaw.ordermanagementj.model.pojo;

public class UserLogin {
    
    private String userIput;
    private String passwordInput;
    private boolean rememberCheck;

    public String getUserIput() {
        return userIput;
    }

    public void setUserIput(String userIput) {
        this.userIput = userIput;
    }

    public String getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(String passwordInput) {
        this.passwordInput = passwordInput;
    }

    public boolean isRememberCheck() {
        return rememberCheck;
    }

    public void setRememberCheck(boolean rememberCheck) {
        this.rememberCheck = rememberCheck;
    }
}
