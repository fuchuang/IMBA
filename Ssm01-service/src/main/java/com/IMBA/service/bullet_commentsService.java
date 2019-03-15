package com.IMBA.service;

import com.IMBA.entity.bullet_comments;
import com.IMBA.entity.clock_in;

import java.util.List;

public interface bullet_commentsService {
    //添加弹幕
    public int addBulletComments(bullet_comments bulletComments);

    //请求一周的弹幕
    public List<String> showWeekComments(int majorId, String year, int week);
}
