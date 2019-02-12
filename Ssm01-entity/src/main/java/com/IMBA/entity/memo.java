package com.IMBA.entity;

public class memo extends memoKey {
    private String memoContent;

    public String getMemoContent() {
        return memoContent;
    }

    public void setMemoContent(String memoContent) {
        this.memoContent = memoContent == null ? null : memoContent.trim();
    }
}