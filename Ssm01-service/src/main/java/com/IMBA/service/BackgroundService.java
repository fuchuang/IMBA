package com.IMBA.service;

import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface BackgroundService {
    //保存背景图
    String saveBgImg(HttpServletRequest request, int stuId, MultipartFile file) throws Exception;

    //查找背景图
    String findImgByStuId(int stu);

}
