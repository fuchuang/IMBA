package com.IMBA.entity;

public class info_functions extends info_functionsKey {
    private String functionName;

    private String imgPath;

    private String functionLink;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public String getFunctionLink() {
        return functionLink;
    }

    public void setFunctionLink(String functionLink) {
        this.functionLink = functionLink == null ? null : functionLink.trim();
    }
}