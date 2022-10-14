package com.example.ereading.service;

import com.example.ereading.domain.defaultbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class defaultbookService {
    @Resource
    private com.example.ereading.mapper.defaultbookMapper defaultbookMapper;
    public List<defaultbook> Gethistorylist(Integer id) {
        return defaultbookMapper.getbookhistorylist(id);
    }
    public List<defaultbook> Getboughtlist(Integer id) {
        return defaultbookMapper.getboughtbooklist(id);
    }
}
