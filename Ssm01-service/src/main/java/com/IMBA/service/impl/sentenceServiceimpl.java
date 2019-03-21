package com.IMBA.service.impl;

import com.IMBA.entity.Sentence;
import com.IMBA.service.sentenceService;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

import org.junit.Test;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static javafx.css.StyleOrigin.USER_AGENT;


@Service("sentenceService")

public class sentenceServiceimpl implements sentenceService {

    public Sentence getSentence() {
        String url="http://open.iciba.com/dsapi";
        HttpGet request=new HttpGet(url);
        HttpClient httpClient= HttpClientBuilder.create().build();
        request.addHeader("User-Agent", String.valueOf(USER_AGENT));
        HttpResponse response= null;
        String content="";
        try {
            response = httpClient.execute(request);
             content= EntityUtils.toString(response.getEntity(),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson=new Gson();
        Map<String,String> jsonMap=gson.fromJson(content, HashMap.class);
        Sentence result=new Sentence();
        result.setContent(jsonMap.get("content"));
        result.setDateline(jsonMap.get("dateline"));
        result.setNode(jsonMap.get("note"));
        result.setPicPath(jsonMap.get("picture"));
        return result;
    }
}
