package com.IMBA.weui.controller;

import com.IMBA.entity.clock_in;
import com.IMBA.service.GoodsService;
import com.IMBA.service.bullet_commentsService;
import com.IMBA.service.clock_inService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    clock_inService clockInService;

    @RequestMapping("/queryGoods")
    public String queryGoods(Model model,String name){
        model.addAttribute("goods",goodsService.queryGoodsByName(name));
        model.addAttribute("name",name);
        clock_in clockIn=new clock_in();
        clockIn.setClockedTime(new Date());
        clockIn.setStudentId(1);
        clockInService.insert(clockIn);

        return "goods/queryGoods";
    }

    //deletes?id=1&id=3&id=5
    @RequestMapping("/deletes")
    public String deletes(Model model, String name, @RequestParam("id") List<Integer> ids){

        String msg="操作成功！";

        if(goodsService.deletes(ids)<=0){
            msg="操作失败！";
        }

        model.addAttribute("msg",msg);
        model.addAttribute("name",name);

        model.addAttribute("goods",goodsService.queryGoodsByName(name));
        return "redirect:goods/queryGoods";
    }
}
