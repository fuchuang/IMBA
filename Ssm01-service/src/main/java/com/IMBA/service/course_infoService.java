package com.IMBA.service;

import com.IMBA.model.coursemodel;

import java.util.List;

public interface course_infoService {
    List<coursemodel> findCouseMsg(int student_id, String year);
    List<coursemodel>findCouseMsgbyteacherid(int teacher,String year);
    int findcourse_hourbycourid(int courseid);
    int findcount();
}
