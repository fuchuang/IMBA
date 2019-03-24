package com.IMBA.service.impl;

import com.IMBA.dao.download_filesMapper;
import com.IMBA.entity.download_files;
import com.IMBA.service.download_filesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service("download_filesService")*/
public class download_filesServiceImpl implements download_filesService {
    @Autowired
    download_filesMapper downloadFilesMapper;

    public int insert(download_files record) {
        return downloadFilesMapper.insert(record);
    }
}
