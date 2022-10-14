package com.example.ereading.mapper;

import com.example.ereading.domain.defaultuser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface SubscribeMapper {
    @Select("SELECT subscribe_id FROM subscribe WHERE subscriber_id = #{id}")
    List<Integer> getsubscribelist(@Param("id") Integer id);
    List<defaultuser> getsubscribelist2(@Param("id") Integer id);
    @Insert("Insert into subscribe values (#{id1},#{id2})")
    void insertsubscribe(@Param("id1") Integer id1,@Param("id2") Integer id2);
    @Delete("Delete from subscribe where subscriber_id=#{id1} and subscribe_id=#{id2}")
    void deletesubscribe(@Param("id1") Integer id1,@Param("id2") Integer id2);

}
