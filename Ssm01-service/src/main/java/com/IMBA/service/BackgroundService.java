package com.IMBA.service;



import com.IMBA.entity.schedule_background;

import java.io.IOException;
import java.io.OutputStream;


public interface BackgroundService {
    //保存背景图
    String saveBgImg(schedule_background bg, int stuId, String pathRoot);

    //查找背景图
    String findImgByStuId(int stu);

    //把图片写入流中
    void writeToStream(OutputStream stream, String path) throws IOException;

}
