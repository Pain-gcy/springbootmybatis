package com.imooc.springbootmybatis.service;

import com.imooc.springbootmybatis.entity.Area;

import java.util.List;

/**
 * @author E470
 * @create 2018 - 05 - 15 10:36
 */
public interface AreaService {

    String queryAreaList();

    Area queryAreaById(int id);

    boolean insertArea(Area area);

    boolean updateArea(Area area);

    boolean deleteArea(int id);
}
