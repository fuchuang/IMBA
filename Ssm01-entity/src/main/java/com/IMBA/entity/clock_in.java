package com.IMBA.entity;

import java.util.Date;

public class clock_in extends clock_inKey {
    private Date clockedTime;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getClockedTime() {
        return clockedTime;
    }

    public void setClockedTime(Date clockedTime) {
        this.clockedTime = clockedTime;
    }
}