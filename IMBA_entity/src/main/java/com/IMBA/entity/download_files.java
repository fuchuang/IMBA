package com.IMBA.entity;

import java.util.Date;

public class download_files extends download_filesKey {
    private Date downloadTime;

    public Date getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }
}