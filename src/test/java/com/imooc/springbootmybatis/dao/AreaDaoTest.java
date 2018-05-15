package com.imooc.springbootmybatis.dao;

import com.imooc.springbootmybatis.config.dao.AreaDao;
import com.imooc.springbootmybatis.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
/**
 * @author E470
 * @create 2018 - 05 - 14 16:52
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryAreaList(){
        List<Area> areas = areaDao.queryAreaList();
        assertEquals(2,areas.size());
    }
    @Test
    @Ignore
    public void queryAreaById(){
        Area area = areaDao.queryAreaById(1);
        assertEquals("河南",area.getAreaName());
    }
    @Test
    @Ignore
    public void insertArea(){
        Area area =new Area();
        area.setAreaCode("021");
        area.setAreaName("山东");
        int i = areaDao.insertArea(area);
        assertEquals(1,i);

    }

    @Test
    @Ignore
    public void updateArea(){
        Area area =new Area();
        area.setId(3);
        area.setAreaName("陕西");
        int i = areaDao.updateArea(area);
        assertEquals(1,i);
    }
    @Test
    public void deleteArea(){
        int i = areaDao.deleteArea(3);
        assertEquals(1,i);
    }
}
