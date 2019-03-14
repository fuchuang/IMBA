package controller;

import com.IMBA.utils.R;
import controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/dataAdmin/")
public class DataAdmin extends BaseController {

    /**
     * TODO 返回视频总数
     * @return
     */
    @GetMapping("VideoCount")
    @ResponseBody
    public R getVideoNumber(){
        int count=videoservice.getAllVideoNum();
        return reToObj(count);
    }

    /**
     * TODO 返回问卷总数
     */
    @GetMapping("QuestionnaireCount")
    @ResponseBody
    public R getQuestionnaireCount(){
        return error();
    }

    /**
     * TODO 返回注册人数 当前在前人数 最高同时在线人数
     */
    @GetMapping("NumberOfUser")
    @ResponseBody
    public R getNumberOfUser(){
        /**
         * 注册人数统计student表和teacher表
         * 当前在线人数
         */
        return error();
    }
}
