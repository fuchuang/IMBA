package com.IMBA.weui.controller.videocontroller;

import com.IMBA.entity.live_video;
import com.IMBA.model.livemodel;
import com.IMBA.service.live_videoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LiveController {
    @Autowired
    live_videoService livevideoService;
    //直播列表
    @RequestMapping(value = "/Live/Livelist")
    @ResponseBody
    JSONObject Livelist(HttpServletRequest request, @RequestParam(name = "start",defaultValue = "0")int start, @RequestParam(name = "rows",defaultValue = "10")int rows){
        PageHelper.startPage(start,rows);
        int live_status=1;
        List<livemodel>live_videos=livevideoService.findvidebylive_status(live_status);
        PageInfo<livemodel> live_videoPageInfo=new PageInfo<>(live_videos);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",live_videoPageInfo);
        return  JSONObject.fromObject(msg);

    }
//    //开始录制
    @RequestMapping(value = "/Live/add")
    @ResponseBody
    JSONObject Liveadd(HttpServletRequest request, @RequestParam(name = "url",defaultValue = "0")String url, @RequestParam(name = "title",defaultValue = "10")String title){
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");
        live_video record=new live_video();
        record.setLivePath(url);
        record.setLiveStatus(true);
        record.setLiveTitle(title);
        record.setStartTime(new Date());
        record.setWatchingNum(0);
        record.setOrganigerId(student_id);
        livevideoService.insert(record);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);

    }
   //观看
   @RequestMapping(value = "/Live/id")
   @ResponseBody
   JSONObject Liveid(HttpServletRequest request, @RequestParam(name = "id",defaultValue = "1")int id){

        live_video liveVideo=livevideoService.findlive_videobyid(id);
        livevideoService.updatewatch_nums(id);
       Map<String,Object> msg=new HashMap<>();
       msg.put("msg",liveVideo);
       return  JSONObject.fromObject(msg);

   }
// 录制结束
   @RequestMapping(value = "/Live/changestatus")
   @ResponseBody
   JSONObject changestatus(HttpServletRequest request, @RequestParam(name = "id",defaultValue = "0")int id){
        livevideoService.updatelive_status(false,id);
       Map<String,Object> msg=new HashMap<>();
       msg.put("msg","success");
       return  JSONObject.fromObject(msg);

   }


}
