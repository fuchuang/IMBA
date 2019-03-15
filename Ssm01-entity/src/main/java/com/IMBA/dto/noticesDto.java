package com.IMBA.dto;

import java.util.Date;

public class noticesDto {
    private Integer id;

    private Date notiDate;

    private String notiSummarized;

    private String notiTitle;

    private boolean isRead;

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNotiDate() {
        return notiDate;
    }

    public void setNotiDate(Date notiDate) {
        this.notiDate = notiDate;
    }

    public String getNotiSummarized() {
        return notiSummarized;
    }

    public void setNotiSummarized(String notiSummarized) {
        this.notiSummarized = notiSummarized;
    }

    public String getNotiTitle() {
        return notiTitle;
    }

    public void setNotiTitle(String notiTitle) {
        this.notiTitle = notiTitle;
    }
}
