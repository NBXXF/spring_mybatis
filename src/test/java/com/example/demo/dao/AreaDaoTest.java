package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * com.example.demo.dao
 * icourt
 * 2018/4/9
 * author:asange
 * email:xuanyouwu@163.com
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areas = areaDao.queryArea();
        System.out.println("======>queryArea:" + areas);
        assertEquals(2, areas.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(3);
        System.out.println("======>queryAreaById:" + area);
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("hh_" + System.currentTimeMillis());
        area.setPriority(new Random().nextInt(10));
        area.setCreateTime(new Date(System.currentTimeMillis()));
        area.setLastEditTime(new Date(System.currentTimeMillis()));
        areaDao.insertArea(area);

        queryArea();
    }

    @Test
    public void updateArea() {
        Area area = areaDao.queryAreaById(3);
        area.setLastEditTime(new Date(System.currentTimeMillis()));
        areaDao.updateArea(area);
    }

    @Test
    public void deleteArea() {
        areaDao.deleteArea(4);
    }
}