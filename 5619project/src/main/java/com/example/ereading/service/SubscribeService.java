package com.example.ereading.service;

import com.example.ereading.mapper.SubscribeMapper;
import com.example.ereading.domain.defaultuser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubscribeService {
    @Resource
    private SubscribeMapper SubscribeMapper;
    public List<Integer> Getlist(Integer id) {
        return SubscribeMapper.getsubscribelist(id);
    }
    public List<defaultuser> Getlist2(Integer id) {
        return SubscribeMapper.getsubscribelist2(id);
    }
    public void add(Integer id1,Integer id2) {
        SubscribeMapper.insertsubscribe(id1,id2);
    }
    public void delete(Integer id1,Integer id2) {
        SubscribeMapper.deletesubscribe(id1,id2);
    }
}
