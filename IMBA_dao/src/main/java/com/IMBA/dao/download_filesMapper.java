package com.IMBA.dao;

import com.IMBA.entity.download_files;
import com.IMBA.entity.download_filesKey;

public interface download_filesMapper {
    int deleteByPrimaryKey(download_filesKey key);

    int insert(download_files record);

    int insertSelective(download_files record);

    download_files selectByPrimaryKey(download_filesKey key);

    int updateByPrimaryKeySelective(download_files record);

    int updateByPrimaryKey(download_files record);
}