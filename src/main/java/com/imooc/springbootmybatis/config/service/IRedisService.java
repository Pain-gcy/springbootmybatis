package com.imooc.springbootmybatis.config.service;

import java.util.List;

/**
 * @author E470
 * @create 2018 - 05 - 22 9:32
 */
public interface IRedisService {
    public boolean set(String key, String value);
    public boolean set(String key, String value,long expire);

    public String get(String key);

    public boolean expire(String key,long expire);

    public <T> boolean setList(String key ,List<T> list);

    public <T> List<T> getList(String key,Class<T> clz);

    public long lpush(String key,Object obj);

    public long rpush(String key,Object obj);

    public String lpop(String key);
}
