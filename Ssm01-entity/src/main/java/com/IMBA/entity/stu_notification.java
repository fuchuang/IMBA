package com.IMBA.entity;

public class stu_notification extends stu_notificationKey {
    private Boolean readStatus;

    private Boolean isCollect;

    public Boolean getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Boolean readStatus) {
        this.readStatus = readStatus;
    }

    public Boolean getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Boolean isCollect) {
        this.isCollect = isCollect;
    }
}