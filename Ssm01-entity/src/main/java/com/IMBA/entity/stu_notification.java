package com.IMBA.entity;

public class stu_notification extends stu_notificationKey {
    private Boolean readStatus;

    private Byte isCollect;

    public Boolean getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Boolean readStatus) {
        this.readStatus = readStatus;
    }

    public Byte getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Byte isCollect) {
        this.isCollect = isCollect;
    }
}