package com.IMBA.weui.controller.admincontroller;

import com.IMBA.model.adminpostmsgmodel;
import com.IMBA.redis.RedisUtil;
import com.IMBA.service.postsService;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.IMBA.weui.controller.communitycontroller.communityController.POSTS_RANK;

@Controller
public class postDatacontroller {
    @Autowired
    postsService postsservice;
    @Autowired
    RedisUtil redisUtil;

    //发帖数目和回帖数目
    @RequiresRoles("admin")
    @RequestMapping(value = "Admin/postmsg")
    @ResponseBody()
    JSONObject Adminpostmsg(){

        int posts=postsservice.findcount();
        int postscomment=postsservice.findcount();
        adminpostmsgmodel adminpostmsgmodel=new adminpostmsgmodel();
        adminpostmsgmodel.setPosts(posts);
        adminpostmsgmodel.setPostscomment(postscomment);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",adminpostmsgmodel);
        return  JSONObject.fromObject(msg);

    }
    //贴子热度
    @RequiresRoles("admin")
    @RequestMapping(value = "Admin/postRank")
    @ResponseBody()
    JSONObject postRank(@RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows){

        Set<ZSetOperations.TypedTuple<String>> rangeWithScores=redisUtil.reverseRangeWithScores(POSTS_RANK,start*rows,(start+1)*rows);
        //查找

        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",rangeWithScores);
        return  JSONObject.fromObject(msg);

    }
}
