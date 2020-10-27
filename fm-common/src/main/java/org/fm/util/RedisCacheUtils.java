package org.fm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.Set;

/**
 * @ProjectName：fm
 * @ClassName：RedisCacheUtils
 * @TODO：
 * @Auth：Mr.Zhang @Time：2020/9/13 21:55
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
public class RedisCacheUtils {

    private JedisPool pool;

    public ObjectMapper mapper;

    private  String SYS_CACHE;

    public RedisCacheUtils(String prefix,JedisPool pool){
        SYS_CACHE=prefix;
        this.pool=pool;
        initMapper();
    }

    public RedisCacheUtils(String prefix, JedisPool pool, ObjectMapper mapper){
        SYS_CACHE=prefix;
        this.pool=pool;
        this.mapper=mapper;
    }


    private void initMapper(){
        mapper = new ObjectMapper();
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public Jedis getJedis(){
        Jedis jedis = pool.getResource();
        return jedis;
    }

    public void returnResource(Jedis jedis ){
        jedis.close();
    }

    /**
     * get
     * @param key
     * @param type
     * @return
     */
    public  <T> T get(String key, TypeReference<T> type) {
        String str = get(key);
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return mapper.readValue(str, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * get
     * @param key
     * @return
     */
    public  String get(String key) {

        Jedis jedis = pool.getResource();
        try {
            return jedis.get(makeKey(key));
        } finally {
            jedis.close();
        }
    }

    /**
     *  key有效的秒数
     * @param key
     * @return
     */
    public Long ttl(String key) {

        Jedis jedis = pool.getResource();
        try {
            return jedis.ttl(makeKey(key));
        } finally {
            jedis.close();
        }
    }
    /**
     * incr 原子加1
     * @param key
     * @return
     */
    public Long incr(String key) {

        Jedis jedis = pool.getResource();
        try {
            return jedis.incr(makeKey(key));
        } finally {
            jedis.close();
        }
    }

    public  void set(String key, Object value) {
        try {
            set(key, mapper.writeValueAsString(value));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public  void set(String key,String value) {
        Jedis jedis = pool.getResource();
        try {
            jedis.set(makeKey(key), value);
        } finally {
            jedis.close();
        }
    }

    public  void set(String key, Object value, int expire) {
        try {
            set(key, mapper.writeValueAsString(value), expire);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public  void set(String key,String value, int expire) {
        Jedis jedis = pool.getResource();
        try {
            jedis.setex(makeKey(key),expire, value);
        } finally {
            jedis.close();
        }
    }

    public  void zadd(final String key, final double score, final String member) {
        Jedis jedis = pool.getResource();
        try {
            jedis.zadd(key, score, member);
        } finally {
            jedis.close();
        }
    }

    public long zcount(final String key) {
        Jedis jedis = pool.getResource();
        try {
            return jedis.zcount(key, "-inf", "+inf");
        } finally {
            jedis.close();
        }
    }

    public Double zscore(final String key,final String member) {
        Jedis jedis = pool.getResource();
        try {
            return jedis.zscore(key, member);
        } finally {
            jedis.close();
        }
    }

    public long zrem(final String key,final String ... members) {
        Jedis jedis = pool.getResource();
        try {
            return jedis.zrem(key, members);
        } finally {
            jedis.close();
        }
    }

    public Set<String> zrevrangeAll(final String key) {
        Jedis jedis = pool.getResource();
        try {
            return jedis.zrevrangeByScore(key, "+inf" ,"-inf");
        } finally {
            jedis.close();
        }
    }
    public Set<String> zrangeByScore(final String key, final String min,
                                     final String max) {
        Jedis jedis = pool.getResource();
        try {
            return jedis.zrangeByScore(key,min,max);
        } finally {
            jedis.close();
        }
    }

    public  boolean exists(String key) {
        Jedis jedis = pool.getResource();
        try {
            return jedis.exists(makeKey(key));
        } finally {
            jedis.close();
        }
    }

    public  void sadd(String key, String [] value, int expire) {
        Jedis jedis = pool.getResource();
        try {
            jedis.sadd(makeKey(key), value);
            expire(key, expire);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            jedis.close();
        }
    }

    public void expire(String key,int expire){
        Jedis jedis = pool.getResource();
        try {
            if (expire != 0) {
                jedis.expire(makeKey(key), expire);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            jedis.close();
        }
    }

    public long del(String key) {
        Jedis jedis = pool.getResource();
        try {
            return jedis.del(makeKey(key));
        } finally {
            jedis.close();
        }
    }

    /**
     * 根据规则删除所有
     *
     * @param pattern
     */
    public long delAll(String pattern) {
        Jedis jedis = pool.getResource();
        try {
            StringBuilder patternSb = new StringBuilder().append(SYS_CACHE)
                    .append(":").append(pattern);
            Set<String> keys = jedis.keys(patternSb.toString());
            long result=0;
            for (String key : keys) {
                result+=jedis.del(key);
            }
            return result;
        } finally {
            jedis.close();
        }
    }

    /**
     * 得到最终key名称
     * @param key
     * @return
     */
    public  String makeKey(String key) {
        if(StringUtils.isNotBlank(SYS_CACHE)){
            return new StringBuilder().append(SYS_CACHE).append(":").append(key)
                    .toString();
        }
        return key;
    }

    public  Set<String> keys(String pattern) {

        Jedis jedis = pool.getResource();
        try {
            return jedis.keys(pattern);
        } finally {
            jedis.close();
        }
    }
}
