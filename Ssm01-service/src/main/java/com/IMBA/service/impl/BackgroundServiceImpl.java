package com.IMBA.service.impl;

import com.IMBA.dao.schedule_backgroundMapper;
import com.IMBA.entity.schedule_background;
import com.IMBA.service.BackgroundService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Service("schedule_backgroundService")
public class BackgroundServiceImpl implements BackgroundService {

    @Autowired
    schedule_backgroundMapper mapper;

    public String saveBgImg(HttpServletRequest request, int stuId, MultipartFile file) throws Exception {
        schedule_background bg=new schedule_background();
        String filename= UUID.randomUUID().toString();
        String ext= FilenameUtils.getExtension(file.getOriginalFilename());
        //项目下的路径
        String pathRoot =request.getSession().getServletContext().getRealPath("/upload");
        file.transferTo(new File(pathRoot +"/"+filename+"."+ext));
        bg.setImgPath("/upload"+filename+"."+ext);
        bg.setStudentId(stuId);
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

    private boolean deleteImg(String realPath,String filePath){
        File file=new File(realPath+filePath);
        if(file.isFile() && file.exists()){
            file.delete();
            return true;
        }
        return false;
    }
}
