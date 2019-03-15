package com.IMBA.service.impl;

import com.IMBA.dao.memoMapper;
import com.IMBA.entity.course;
import com.IMBA.entity.memo;
import com.IMBA.entity.memoKey;
import com.IMBA.service.memoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("memoService")
public class memoServiceImpl implements memoService {
    @Autowired
    memoMapper mapper;
    //返回值为新增memo的id
    public int addMemo(int stuId, int courseId, String content) {
        memo m=new memo();
        m.setMemoContent(content);
        m.setCourseId(courseId);
        m.setStudentId(stuId);
        return mapper.insertMemo(m);
    }

    public int editMemo(int memoId, String content) {
        memo m=mapper.findById(memoId);
        if (m!=null){
            m.setMemoContent(content);
            int n=mapper.updateByPrimaryKey(m);
            return n;
        }
        return 0;


    }

    public int deleteMemo(int memoId) {
        int n=mapper.deleteById(memoId);
        return n;
    }

    public List<memo> showMemoInWeek(int stuId, List<course> courses) {
        List<memo> memos=new ArrayList<memo>();
        if(courses!=null){
            for (int i=0;i<courses.size();i++){
                memoKey mk=new memoKey();
                mk.setStudentId(stuId);
                mk.setCourseId(courses.get(i).getId());
                memo m=mapper.selectByPrimaryKey(mk);
                if (m!=null){
                    memos.add(m);
                }
            }
        }
        return memos;
    }
}
