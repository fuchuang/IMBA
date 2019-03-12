package com.IMBA.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FFmpegUtil {
    private String ffmpegexe;

    public FFmpegUtil(String ffmpegexe) {
        this.ffmpegexe = ffmpegexe;
    }
    //视频转换
    public void convertor(String videoInputPath,String videoOutputPath) throws IOException {

        List<String>command=new ArrayList<String>();
        command.add(ffmpegexe);
        command.add("-i");
        command.add(videoInputPath);
        command.add(videoOutputPath);
        ProcessBuilder processBuilder=new ProcessBuilder(command);
        Process process=processBuilder.start();
        InputStream errorStream=process.getErrorStream();
        InputStreamReader inputStreamReader=new InputStreamReader(errorStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line="";
        while ((line=bufferedReader.readLine())!=null){
            bufferedReader.close();
        }
        if (inputStreamReader!=null){
            inputStreamReader.close();
        }
        if (errorStream!=null){
            errorStream.close();
        }
    }
    //封面

}
