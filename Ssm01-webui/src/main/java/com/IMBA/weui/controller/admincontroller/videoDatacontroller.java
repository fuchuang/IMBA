package com.IMBA.weui.controller.admincontroller;

import com.IMBA.model.adminlikemsgmodel;
import com.IMBA.model.videowatchnumsrank;
import com.IMBA.service.video_seriesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class videoDatacontroller {
    @Autowired
    video_seriesService videoSeriesService;
    //视频观看人数
    @RequiresRoles("admin")
    @RequestMapping(value = "Admin/videowatchnums")
    @ResponseBody()
    JSONObject Adminvideowatchnums(@RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "3")int rows){
        Map<String,Object> msg=new HashMap<>();
        PageHelper.startPage(start,rows);
        List<videowatchnumsrank> videowatchnumsrankList=videoSeriesService.findbywatchnums();
        PageInfo<videowatchnumsrank> pageInfo=new PageInfo( videowatchnumsrankList);
        msg.put("msg",pageInfo);
        return  JSONObject.fromObject(msg);

    }
    //视频观看时长？
    //视频点赞数
    @RequiresRoles("admin")
    @RequestMapping(value = "Admin/likehnums")
    @ResponseBody()
    JSONObject Adminlikehnums(@RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "3")int rows){
        Map<String,Object> msg=new HashMap<>();
        List<adminlikemsgmodel>adminlikemsgmodelList=videoSeriesService.findlikenums();
        msg.put("msg",adminlikemsgmodelList);
        return  JSONObject.fromObject(msg);

    }



}
