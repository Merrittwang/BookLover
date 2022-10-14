package com.example.ereading;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
@MapperScan("com.example.ereading.mapper")
class ApplicationTests {

    @Autowired //自动装配
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }


}
