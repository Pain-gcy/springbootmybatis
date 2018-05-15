package com.imooc.springbootmybatis.web;

import com.imooc.springbootmybatis.config.dao.AreaDao;
import com.imooc.springbootmybatis.entity.Area;
import com.imooc.springbootmybatis.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author E470
 * @create 2018 - 05 - 15 11:33
 */
@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/list")
    public Map<String,Object> getAreaList(){
        Map<String,Object> map = new HashMap<>();
        List<Area> areas = areaService.queryAreaList();
        map.put("arealist",areas);
        return map;
    }

    @GetMapping(value = "/getareabyid")
    public Map<String,Object> getAreaById(Integer id){
        Map<String,Object> map = new HashMap<>();
        Area areas = areaService.queryAreaById(id);
        map.put("area",areas);
        return map;
    }

    @PostMapping(value = "/addarea")
    public Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<>();
        map.put("success",areaService.insertArea(area));
        return map;
    }
    @PostMapping(value = "/updatearea")
    public Map<String,Object> updateArea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<>();
        map.put("success",areaService.updateArea(area));
        return map;
    }
    @GetMapping(value = "/deletearea")
    public Map<String,Object> deleteArea(Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("success",areaService.deleteArea(id));
        return map;
    }




}
