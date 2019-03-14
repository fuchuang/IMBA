package com.IMBA.service.impl;

import com.IMBA.dao.stu_courseMapper;
import com.IMBA.dto.stuCourseDto;
import com.IMBA.entity.course;
import com.IMBA.service.stu_courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.IMBA.entity.stu_courseKey;
import java.util.ArrayList;
import java.util.List;

@Service("stu_courseService")
public class stu_courseServiceImpl implements stu_courseService {
    @Autowired
    stu_courseMapper mapper;

    public List<course> findCoursesOfWeek(Integer stuId, String year, Byte week) {
        List<course> courses= mapper.findCoursesOfWeek(stuId,year, week);
        return courses;
    }

    public List<course> findCoursesOfDay(Integer stuId, String year, Byte week, Byte day) {
        List<course> coursesInWeek=findCoursesOfWeek(stuId,year,week);
        List<course> coursesInDay=new ArrayList<course>();
        if(coursesInWeek!=null){
            for (int i=0;i<coursesInWeek.size();i++){
                course c=coursesInWeek.get(i);
                if(c.getDayOfWeek()==day){
                    coursesInDay.add(c);
                }
            }
        }
        return coursesInDay;
    }

    public int addStuCourse(int stuId, int courseId) {
        stu_courseKey courseKey=new stu_courseKey();
        courseKey.setStudentId(stuId);
        courseKey.setCourseId(courseId);
        int id;
        try{
             mapper.insertSelective(courseKey);
             id=courseKey.getId();
        }catch (Exception e){

            return -1;
        }
        return id;
    }

    public List<stuCourseDto> findCoursesList(int stuId) {
        List<stuCourseDto> list=mapper.findCoursesList(stuId);
        return list;
    }

    public List<Integer> findMajorByCourseId(int courseId) {
        return mapper.selectMajorIdByCourseId(courseId);
    }

    public List<course> findCourseOfSemester(int stuId, String year) {
        List<course> result=mapper.findCoursesOfSemester(stuId,year);
        return result;
    }

    public boolean deleteCourse(int stuCourseId) {
        int n=mapper.deleteById(stuCourseId);
        if (n==1)return true;
        return false;
    }

    public int findCourseIdById(int id) {
         return mapper.selectById(id).getCourseId();
    }

}
