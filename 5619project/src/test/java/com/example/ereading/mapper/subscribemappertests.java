package com.example.ereading.mapper;

import com.example.ereading.domain.defaultuser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class subscribemappertests {
    @Autowired
    private SubscribeMapper vipMapper;
    @Test
    public void get() {
        System.out.println("start...");
        List<Integer> list=vipMapper.getsubscribelist(1);
        System.out.println(list);
        System.out.println("end");
    }
    @Test
    public void get2() {
        System.out.println("start...");
        List<defaultuser> list=vipMapper.getsubscribelist2(1);
        for (defaultuser item : list) {
            System.out.println(item.getName());
            System.out.println(item.getUid());
        }
        System.out.println("end");
    }
    @Test
    public void add() {
        System.out.println("start...");
        vipMapper.insertsubscribe(2,1);
        System.out.println("end");
    }
    @Test
    public void delete() {
        System.out.println("start...");
        vipMapper.deletesubscribe(2,1);
        System.out.println("end");
    }
}
