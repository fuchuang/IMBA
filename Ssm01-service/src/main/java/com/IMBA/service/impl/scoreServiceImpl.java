package com.IMBA.service.impl;

import com.IMBA.dao.scoreMapper;
import com.IMBA.dto.courseScoresDto;
import com.IMBA.service.scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("scoreService")
public class scoreServiceImpl implements scoreService {
    @Autowired
    scoreMapper mapper;
    public float getGPAByTerm(int stuId, String year) {
        List<courseScoresDto> result=mapper.selectCourseScores(stuId,year);
        if (result.size()==0){
            return 0;
        }
        float GPA=countGPA(result);
        return GPA;
    }

    public float getAverageGPA(int stuId) {
        List<courseScoresDto> result=mapper.selectAllCourseScore(stuId);
        float GPA=countGPA(result);
        return GPA;
    }

    public List getScoresByTerm(int stuId, String year) {
        List<courseScoresDto> result=mapper.selectCourseScores(stuId,year);
        return result;
    }



    //课程绩点=成绩/10 -5  平均绩点=(课程学分1*绩点+课程学分2*绩点+课程学分n*绩点)/( 课程学分1+课程学分2+课程学分n)
    private float countGPA(List<courseScoresDto> list){
        float GPACount =0;
        float creditCount=0;
        for (int i=0;i<list.size();i++){
            courseScoresDto record=list.get(i);
            float temp;
            if (record.getScore()>=60){
                temp=record.getScore()/10-5;
            }else {
                temp=0;
            }

            GPACount+=temp*record.getCourseCredit();
            creditCount+=record.getCourseCredit();
        }
        if (creditCount!=0){
            return GPACount/creditCount;
        }else {
            return -1;
        }
    }
    public int getRankInMajor(int stuId,String year) {
        List<Integer> studentsId=mapper.selectStudentsIdByMajor(stuId);
        List<Float> GPAList=new ArrayList<Float>();
        for (int i=0;i<studentsId.size();i++){
            int id=studentsId.get(i);
            if (id!=stuId){
                float gpa=getGPAByTerm(id,year);
                GPAList.add(gpa);
            }
        }
        int rank=getRank(GPAList,getGPAByTerm(stuId,year));
        return rank;
    }

    private int getRank(List<Float> list,float record){
        Collections.sort(list);
        Collections.reverse(list);
        for (int i=0;i<list.size();i++){
            if (list.get(i)<=record)return i+1;
        }
        return list.size()+1;
    }
}
