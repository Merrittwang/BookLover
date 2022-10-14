package com.example.ereading.mapper;

import com.example.ereading.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Date;



public interface UserMapper {


    Integer insert(User user);


    User findByUsername(String username);


    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modifiedUser,
                                Date modifiedTime);


    User findByUid(Integer uid);


    Integer updateInfoByUid(User user);


    Integer updateAvatarByUid(@Param("uid") Integer iddddd,
                              String avatar,
                              String modifiedUser,
                              Date modifiedTime);
}