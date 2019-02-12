package com.IMBA.entity;

import java.util.Date;

public class clock_in extends clock_inKey {
    private Date clockedTime;

    public Date getClockedTime() {
        return clockedTime;
    }

    public void setClockedTime(Date clockedTime) {
        this.clockedTime = clockedTime;
    }
}