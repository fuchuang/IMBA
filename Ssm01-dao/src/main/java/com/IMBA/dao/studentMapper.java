package com.IMBA.dao;

import com.IMBA.entity.student;
import com.IMBA.entity.studentKey;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface studentMapper {


    public student findstudentBystuid(String stuid);
    public student findstudentByid(int id);
    public List<student>selectall();
    public int findmajor(int stuid);



    int deleteByPrimaryKey(studentKey key);

    int insert(student record);

    int insertSelective(student record);

    student selectByPrimaryKey(studentKey key);

    int updateByPrimaryKeySelective(student record);

    int updateByPrimaryKey(student record);
}