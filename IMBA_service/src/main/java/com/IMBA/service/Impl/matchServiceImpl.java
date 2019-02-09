package com.IMBA.service.Impl;

import com.IMBA.dao.matchMapper;
import com.IMBA.service.matchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("matchService")
public class matchServiceImpl implements matchService {
    @Autowired
    matchMapper matchmapper;
}
