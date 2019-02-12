package com.IMBA.service.impl;

import com.IMBA.dao.elective_collectionsMapper;
import com.IMBA.entity.elective_collections;
import com.IMBA.service.elective_collectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("elective_collectionsService")
public class elective_collectionsServiceImpl implements elective_collectionsService {
    @Autowired
    elective_collectionsMapper electiveCollectionsMapper;

}
