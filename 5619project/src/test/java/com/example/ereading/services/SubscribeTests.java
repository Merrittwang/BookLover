package com.example.ereading.services;
import com.example.ereading.service.SubscribeService;
import com.example.ereading.service.VIPService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscribeTests {
    @Autowired
    private SubscribeService SubscribeService;
    @Test
    public void Getall() {
        try {
        System.out.println("get all...");
        List<Integer> list=SubscribeService.Getlist(1);
        System.out.println(list);
    } catch (Exception e) {
        System.out.println("获取失败！" + e.getClass().getSimpleName());
        System.out.println(e.getMessage());
    }
    }

}
