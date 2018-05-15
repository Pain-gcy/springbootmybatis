package com.imooc.springbootmybatis.config.dao;

import com.imooc.springbootmybatis.entity.Area;

import java.util.List;

/**
 * @author E470
 * @create 2018 - 05 - 14 15:20
 */
public interface AreaDao {

    List<Area> queryAreaList();

    Area queryAreaById(int id);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(int id);

}
