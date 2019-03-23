package com.IMBA.service.impl;

import com.IMBA.dao.schedule_backgroundMapper;
import com.IMBA.entity.schedule_background;
import com.IMBA.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


@Service("schedule_backgroundService")
public class BackgroundServiceImpl implements BackgroundService {

    @Autowired
    schedule_backgroundMapper mapper;

    public String saveBgImg(schedule_background bg, int stuId,String pathRoot)  {

        schedule_background back=mapper.selectByStuId(stuId);
        if(back!=null){
            //先删除原来的照片
            deleteImg(pathRoot,back.getImgPath());
            if(mapper.updateByStuId(bg)==1){
                return bg.getImgPath();
            }
        }else {
            if(mapper.insert(bg)==1){
                return bg.getImgPath();
            }
        }
        return null;

    }


    public String findImgByStuId(int stuId) {
        schedule_background bg= mapper.selectByStuId(stuId);
        if (bg!=null)return bg.getImgPath();
        else return null;
    }

    public void writeToStream(OutputStream stream, String path) throws IOException {
        FileInputStream inputStream=null;
        try {
            inputStream=new FileInputStream(new File(path));
            int len=0;
            byte[] buffer=new byte[1024*10];
            while ((len=inputStream.read(buffer))!=-1){
                stream.write(buffer,0,len);
            }
            stream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            stream.close();
            inputStream.close();
        }
    }

    private boolean deleteImg(String realPath,String filePath){
        File file=new File(realPath+filePath);
        if(file.isFile() && file.exists()){
            file.delete();
            return true;
        }
        return false;
    }
}
