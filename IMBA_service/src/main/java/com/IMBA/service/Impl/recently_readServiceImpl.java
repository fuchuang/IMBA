package com.IMBA.service.Impl;

import com.IMBA.dao.recently_readMapper;
import com.IMBA.service.recently_readService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recently_readService")
public class recently_readServiceImpl implements recently_readService {
    @Autowired
    recently_readMapper readMapper;

}
