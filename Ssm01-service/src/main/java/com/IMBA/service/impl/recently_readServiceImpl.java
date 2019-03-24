package com.IMBA.service.impl;

import com.IMBA.dao.recently_readMapper;
import com.IMBA.entity.recently_readKey;
import com.IMBA.service.recently_readService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service("recently_readService")*/
public class recently_readServiceImpl implements recently_readService {
    @Autowired
    recently_readMapper readMapper;

    public recently_readKey findbypostid(int postid, int stuid) {
        return readMapper.findbypostid(postid,stuid);
    }

    public int insert(recently_readKey record) {
        return readMapper.insert(record);
    }
}
