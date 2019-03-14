package com.IMBA.service;

public interface electiveLikeService {
    boolean isLiked(int stuId,int electiveId);
    boolean addLkie(int stuId,int electiveId);
    boolean deleteLike(int stuId,int electiveId);
}
