package com.IMBA.redis;


import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;



@Service
public class RedisUtil {
    @Autowired
    private RedisTemplate<String,String> clusterRedisTemplate;
    public void put(Object key, Object value){
        if (null==value){
            return;
        }
        if (value instanceof  String){
            if (StringUtils.isEmpty(value.toString())){
                return;
            }
        }
        final String keyf = key + "";
        final Object valuef = value;
        final long liveTime = 86400;
        clusterRedisTemplate.execute((RedisCallback<Long>) connection -> {
                      byte[] keyb = keyf.getBytes();byte[] valueb = toByteArray(valuef);
                      connection.set(keyb, valueb);
                      if (liveTime > 0) {
                          connection.expire(keyb, liveTime);
                      }return 1L; });



    }
    public void lpush(String key,String Object){
        clusterRedisTemplate.opsForList().leftPush(key,Object);
    }
    public void incrementScore(String k,String v,double v1 ){
        clusterRedisTemplate.opsForZSet().incrementScore(k,v,v1);
    }
    public double score(String v,String key){
        return clusterRedisTemplate.opsForZSet().score(v, key);

    }
    public long opsForZSetzCard(String k){

        return clusterRedisTemplate.opsForZSet().zCard(k);
    }
    public void opsForZsetadd(String k,String key,double s){
        clusterRedisTemplate.opsForZSet().add(k, key,s);
    }
    public Long reverseRank(String k, String key){
        return clusterRedisTemplate.opsForZSet().reverseRank(k,key);
    }

public Set<ZSetOperations.TypedTuple<String>>reverseRangeWithScores(String k,int s,int r){
        return clusterRedisTemplate.opsForZSet().reverseRangeWithScores(k,s,r);

}
//    public Set<String>keys(String key ){
////        return  clusterRedisTemplate.keys(key+"*");
//        return clusterRedisTemplate.opsForZSet().
//    }
    public void set(String key,String value){
        clusterRedisTemplate.opsForSet().add(key,value);
    }
    public Set<String>member(String key){
       return clusterRedisTemplate.opsForSet().members(key);
    }
    public  boolean hasKey(Object key){

        return clusterRedisTemplate.hasKey((String) key);
    }
    public Object get(Object key) {
        final String keyf = (String) key;
        Object object;

        object = clusterRedisTemplate.execute((RedisCallback<Object>) connection -> {
            byte[] key1 = keyf.getBytes();
            byte[] value = connection.get(key1);
            if (value == null) {
                return null;
            }return toObject(value);
        });
        return object;
    }

    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
            } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

     private Object toObject(byte[] bytes) {
        Object obj = null;

        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }









}
