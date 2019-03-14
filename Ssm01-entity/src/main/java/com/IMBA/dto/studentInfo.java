package com.IMBA.dto;

import com.IMBA.entity.major;
import com.IMBA.entity.student;

public class studentInfo {
    String name;
    String sex;
    String mClass;
    String personalInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    public String getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(String personalInfo) {
        this.personalInfo = personalInfo;
    }

    public void setInfo(student record, major majorRecord){
        this.name=record.getStuName();
        this.sex=record.getSex();
        this.personalInfo=record.getPersonalizedSignatures();
        this.mClass=majorRecord.getGrade()+"级"+majorRecord.getMarjorName()+record.getClass()+"班";
    }
}
