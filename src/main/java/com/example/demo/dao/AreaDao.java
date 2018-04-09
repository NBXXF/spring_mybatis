package com.example.demo.dao;

import com.example.demo.entity.Area;

import java.util.List;

/**
 * com.example.demo.dao
 * icourt
 * 2018/4/9
 * author:asange
 * email:xuanyouwu@163.com
 **/
public interface AreaDao {

    List<Area> queryArea();

    Area queryAreaById(int id);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(int id);
}
