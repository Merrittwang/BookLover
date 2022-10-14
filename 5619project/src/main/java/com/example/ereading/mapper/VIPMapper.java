package com.example.ereading.mapper;

import com.example.ereading.domain.User;
import com.example.ereading.domain.VIP;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VIPMapper {
    @Select("SELECT vip FROM user WHERE account_id = #{id}")
    Integer getvip(@Param("id") Integer id);

    @Select("SELECT points FROM user WHERE account_id = #{id}")
    Integer getpoints(@Param("id") Integer id);

    @Select("SELECT online_time FROM today_inf WHERE user_id = #{id}")
    Integer gettodaypoints(@Param("id") Integer id);

    @Update("update user set points=points+20 where account_id = #{id}")
    void buypoints(@Param("id") Integer id);

    @Update("update user set vip=vip+20 where account_id = #{id}")
    void buyvip(@Param("id") Integer id);

    @Update("update user set points=points-#{i} where account_id = #{id}")
    void usepoints(Integer i, Integer uid);
}
