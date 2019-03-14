package com.IMBA.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class DownloadFile {

    public static void download(HttpServletResponse response, String path){
        try {
            path= URLEncoder.encode(path,"UTF-8");
            InputStream bis=new BufferedInputStream(new FileInputStream(path));
            response.addHeader("Content-Disposition", "attachment;filename=" + path);
            response.setContentType("multipart/form-data");
            BufferedOutputStream out=new BufferedOutputStream(response.getOutputStream());
            int len=0;
            while ((len=bis.read())!=-1){
                out.write(len);
                out.flush();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void download(OutputStream outputStream,String path){
        try {
            InputStream bis=new BufferedInputStream(new FileInputStream(path));
            BufferedOutputStream out=new BufferedOutputStream(outputStream);
            int len=0;
            while ((len=bis.read())!=-1){
                out.write(len);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
