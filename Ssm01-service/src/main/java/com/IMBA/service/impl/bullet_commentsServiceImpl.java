package com.IMBA.service.impl;

import com.IMBA.dao.bullet_commentsMapper;
import com.IMBA.entity.bullet_comments;
import com.IMBA.entity.clock_in;
import com.IMBA.service.bullet_commentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*@Service()*/
public class bullet_commentsServiceImpl implements bullet_commentsService {
        @Resource
        private bullet_commentsMapper bullet_commentsMapper;
        public int addBulletComments(bullet_comments bulletComments) {
                int n=bullet_commentsMapper.insert(bulletComments);
                return n;
        }

        public List<String> showWeekComments(int majorId, String year, int week) {
                List<String> resultList=new ArrayList<String>();
                List<bullet_comments> list=bullet_commentsMapper.selectByWeek(majorId,year, (byte) week);
                if(!list.isEmpty()){
                        for (int i=0;i<list.size();i++){
                                resultList.add(list.get(i).getContent());
                        }
                }
                return resultList;
        }


}
