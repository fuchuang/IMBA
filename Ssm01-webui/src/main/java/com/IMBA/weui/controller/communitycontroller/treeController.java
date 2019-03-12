package com.IMBA.weui.controller.communitycontroller;

import com.IMBA.entity.major;
import com.IMBA.redis.RedisUtil;
import com.IMBA.service.majorService;
import com.IMBA.service.registerService;
import com.IMBA.service.studentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import static com.IMBA.weui.controller.communitycontroller.teacherController.MAJOR_COLLETION;
import static com.IMBA.weui.controller.communitycontroller.teacherController.SCORE_RANK;

@Controller
public class treeController {
    //签到
    //专业班级--迟到或者旷课数量
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    majorService majorservice;
    @Autowired
    studentService studentservice;
    @Autowired
    registerService registerservice;
    public static  final String AVERAGE_SCORE_RANK= "average_score_rank";



    @RequestMapping(value = "/tree/list")
    @ResponseBody()
    JSONObject treelist(HttpServletRequest request,@RequestParam(name = "start",defaultValue = "0")int start,@RequestParam(name = "rows",defaultValue = "10")int rows){
        //查找专业班级
        List<major>majorList=majorservice.findAll();

        for (major mj:majorList){
            String mojorcourse=mj.getGrade()+mj.getMarjorName()+mj.getClasses()+"班";
            System.out.println(mojorcourse);
            double total=0;
            int nums=0;
            Set<String>keySet=redisUtil.member(MAJOR_COLLETION);

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
                }
            }

        }
        Set<ZSetOperations.TypedTuple<String>> rangeWithScores=redisUtil.reverseRangeWithScores(AVERAGE_SCORE_RANK,start*rows,(start+1)*rows);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",rangeWithScores);
        return  JSONObject.fromObject(msg);

    }
    //浇水
    //
    @RequestMapping(value = "/tree/classes")
    @ResponseBody()
    JSONObject treeclasses(HttpServletRequest request,@RequestParam(name = "start",defaultValue = "0")int start,@RequestParam(name = "rows",defaultValue = "10")int rows){

        //今天
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");//账号
        //专业的同学的id的时间
        int major_id=studentservice.findmajor(student_id);
        String status="arrive";
        PageHelper.startPage(start,rows);
        List<String>stringList=registerservice.findstudent(status,major_id);
        PageInfo<String>pageInfo=new PageInfo<>(stringList);

        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",pageInfo);
        return  JSONObject.fromObject(msg);

    }


}
