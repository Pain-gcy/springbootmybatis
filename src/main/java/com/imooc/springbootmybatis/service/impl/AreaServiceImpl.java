package com.imooc.springbootmybatis.service.impl;


import com.google.gson.Gson;
import com.imooc.springbootmybatis.config.dao.AreaDao;
import com.imooc.springbootmybatis.config.service.IRedisService;
import com.imooc.springbootmybatis.entity.Area;
import com.imooc.springbootmybatis.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author E470
 * @create 2018 - 05 - 15 10:37
 */
@Service
public class AreaServiceImpl implements AreaService {

    protected static Logger logger= LoggerFactory.getLogger(AreaServiceImpl.class);

    @Autowired
    private AreaDao areaDao;

    //redis缓存
    @Autowired
    private RedisTemplate redisTemplate;

    //Redis 缓存服务接口
    @Autowired
    private IRedisService redisService;
    @Override
    public String queryAreaList() {
  /*     ValueOperations valueOperations = redisTemplate.opsForValue();
        String info1 = (String)valueOperations.get("info");*/
        String info = redisService.get("info");
        if (!"".equals(info)){

            return info;
        }else {
            List<Area> areas = areaDao.queryAreaList();
            //valueOperations.set("info",areas.toString());
            redisService.set("info",areas.toString());

            logger.info("{}",areas.toString());
            return areas.toString();
        }
    }

    @Override
    public Area queryAreaById(int id) {
        logger.info("传入的id："+id);
        return areaDao.queryAreaById(id);
    }

    @Transactional
    //@Transactional(rollbackFor = Exception.class) 可以自定义抛出异常
    @Override
    public boolean insertArea(Area area) {
        if (!StringUtils.isEmpty(area.getAreaName())){
            Date date = new Date();
            area.setCreateTime(date.toString());
            area.setLastEditTime(date.toString());
            try {
                int i = areaDao.insertArea(area);
                if (i>0){
                    return true;
                }else{
                    throw new RuntimeException("插入信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }
    @Transactional
    @Override
    public boolean updateArea(Area area) {
        if (!StringUtils.isEmpty(area.getAreaName())){
            Date date = new Date();
            area.setCreateTime(date.toString());
            area.setLastEditTime(date.toString());
            try {
                int i = areaDao.updateArea(area);
                if (i>0){
                    return true;
                }else{
                    throw new RuntimeException("更新信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("更新信息失败:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int id) {
        if (id>0){
            try {
                int i = areaDao.deleteArea(id);
                if (i>0){
                    return true;
                }else{
                    throw new RuntimeException("删除信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除信息失败:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("id必须大于0");
        }
    }
}
