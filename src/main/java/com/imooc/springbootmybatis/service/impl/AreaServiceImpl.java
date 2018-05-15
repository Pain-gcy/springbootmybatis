package com.imooc.springbootmybatis.service.impl;

import com.imooc.springbootmybatis.config.dao.AreaDao;
import com.imooc.springbootmybatis.entity.Area;
import com.imooc.springbootmybatis.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author E470
 * @create 2018 - 05 - 15 10:37
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryAreaList() {
        return areaDao.queryAreaList();
    }

    @Override
    public Area queryAreaById(int id) {
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
