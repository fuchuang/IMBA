package com.IMBA.entity;

import java.util.Date;

public class register extends registerKey {
    private String registerStatus;

    private Date registerTime;

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus == null ? null : registerStatus.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}