package com.IMBA.service;



import com.IMBA.entity.schedule_background;


public interface BackgroundService {
    //保存背景图
    String saveBgImg(schedule_background bg, int stuId, String pathRoot);

    //查找背景图
    String findImgByStuId(int stu);

}
