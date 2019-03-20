package com.IMBA.weui.controller.admincontroller;

import com.IMBA.entity.major;
import com.IMBA.redis.RedisUtil;
import com.IMBA.service.course_infoService;
import com.IMBA.service.majorService;
import com.IMBA.service.registerService;
import com.IMBA.service.studentService;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import static com.IMBA.weui.controller.communitycontroller.teacherController.MAJOR_COLLETION;
import static com.IMBA.weui.controller.communitycontroller.teacherController.SCORE_RANK;

@Controller
public class communityDatacontroller {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    majorService majorservice;
    @Autowired
    studentService studentservice;
    @Autowired
    registerService registerservice;
    @Autowired
    course_infoService courseInfoService;
    public static  final String AVERAGE_SCORE_RANK= "average_score_rank";
    //树排名
    @RequiresRoles("admin")
    @RequestMapping(value = "Admin/treelist")
    @ResponseBody()
    JSONObject Admintreelist(HttpServletRequest request, @RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows){
        //查找专业班级
        List<major> majorList=majorservice.findAll();

        for (major mj:majorList){
            String mojorcourse=mj.getGrade()+mj.getMarjorName()+mj.getClasses()+"班";
            System.out.println(mojorcourse);
            double total=0;
            int nums=0;
            Set<String> keySet=redisUtil.member(MAJOR_COLLETION);

            for (String key :keySet){
                String pattern = mojorcourse+".*";
                if (Pattern.matches(pattern,key)){
                    nums++;
                }
            }
            if (nums>0){
                total=redisUtil.score(SCORE_RANK,mojorcourse);
                double average=total/nums;

                //求出平均分
                if(average>0){
                    redisUtil.opsForZsetadd(AVERAGE_SCORE_RANK,mojorcourse, average);
                }else {
                    redisUtil.opsForZsetadd(AVERAGE_SCORE_RANK,mojorcourse, 0.0);
                }
            }

        }
        Set<ZSetOperations.TypedTuple<String>> rangeWithScores=redisUtil.reverseRangeWithScores(AVERAGE_SCORE_RANK,start*rows,(start+1)*rows);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",rangeWithScores);
        return  JSONObject.fromObject(msg);

    }
    //社群数目
    @RequiresRoles("admin")
    @RequestMapping(value = "Admin/communitynums")
    @ResponseBody()
    JSONObject communitynums(){
        int count=courseInfoService.findcount();
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",count);
        return  JSONObject.fromObject(msg);

    }
    //学校数目?




}
