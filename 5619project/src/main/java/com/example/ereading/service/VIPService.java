package com.example.ereading.service;

import com.example.ereading.domain.VIP;
import com.example.ereading.mapper.VIPMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VIPService {

    @Resource
    private VIPMapper vipMapper;
    public Integer Getpoints(Integer id) {
        return vipMapper.getpoints(id);
    }
    public Integer Getvip(Integer id) {
        return vipMapper.getvip(id);
    }
    public Integer Gettodaypoints(Integer id) {
        return vipMapper.gettodaypoints(id);
    }
    public VIP Getall(Integer id) {
        VIP V=new VIP();
        V.setPoints(Getpoints(id));
        V.setVip(Getvip(id));
        V.setOnline_time(Gettodaypoints(id));
        return V;
    }
    public void Buypoints(Integer id) {
        vipMapper.buypoints(id);
    }
    public void Buyvip(Integer id) {
        vipMapper.buyvip(id);
    }

    public void paybook(Integer i, Integer uid) {
        vipMapper.usepoints(i,uid);
    }
}
