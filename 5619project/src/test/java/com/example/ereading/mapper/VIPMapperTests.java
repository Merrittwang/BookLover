package com.example.ereading.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VIPMapperTests {
    @Autowired
    private VIPMapper vipMapper;
    @Test
    public void find() {
        System.out.println("start...");
        Integer vip = vipMapper.getpoints(1);
        System.out.println(vip);
    }
}
