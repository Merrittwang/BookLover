package com.example.ereading.mapper;

import com.example.ereading.domain.defaultbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class defaultbookmappertests {
    @Autowired
    private defaultbookMapper bookMapper;
    @Test
    public void get() {
        System.out.println("start...");
        List<defaultbook> list=bookMapper.getbookhistorylist(1);
        for (defaultbook item : list) {
            System.out.println(item.getBook_id());
            System.out.println(item.getBook_name());
        }
        System.out.println("end");
    }
    @Test
    public void get2() {
        System.out.println("start...");
        List<defaultbook> list=bookMapper.getboughtbooklist(1);
        for (defaultbook item : list) {
            System.out.println(item.getBook_id());
            System.out.println(item.getBook_name());
        }
        System.out.println("end");
    }
}
