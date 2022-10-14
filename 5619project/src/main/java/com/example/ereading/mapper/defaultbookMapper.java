package com.example.ereading.mapper;

import com.example.ereading.domain.defaultbook;
import com.example.ereading.domain.defaultuser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
public interface defaultbookMapper {

    List<defaultbook> getbookhistorylist(@Param("id") Integer id);

    List<defaultbook> getboughtbooklist(@Param("id") Integer id);
}
