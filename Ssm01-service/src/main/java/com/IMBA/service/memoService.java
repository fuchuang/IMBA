package com.IMBA.service;

import com.IMBA.entity.course;
import com.IMBA.entity.memo;

import java.util.List;

public interface memoService {


    //添加备忘录
    int addMemo(int stuId,int courseId,String content);

    //修改备忘录
    int editMemo(int memoId,String content);

    //删除备忘录
    int deleteMemo(int memoId);

    //查看一周的备忘录
    List<memo> showMemoInWeek(int stuId, List<course>  courses);
}
