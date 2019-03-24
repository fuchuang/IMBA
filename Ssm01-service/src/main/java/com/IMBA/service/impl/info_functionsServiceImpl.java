package com.IMBA.service.impl;

import com.IMBA.dao.info_functionsMapper;
import com.IMBA.service.info_functionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service("info_functionsService")*/
public class info_functionsServiceImpl implements info_functionsService {
    @Autowired
    info_functionsMapper infoFunctionsMapper;
}
