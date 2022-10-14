package com.example.ereading.mapper;

import com.example.ereading.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper

public interface BookMapper {
    List<Book> findHotList1();

    @Select("SELECT book_name FROM book WHERE book_id = #{id}")
    String getBookName(@Param("id") Integer id);

    @Select("SELECT authors FROM book WHERE book_id = #{id}")
    String getAuthorName(@Param("id") Integer id);

    List<Book> findHotList2();

    List<Book> findHotList3();

    List<Book> findHotList4();

    List<Book> SearchList(String bookName,String author,String category,int years);

    List<Book> findList1();
    List<Book> findList2();
    List<Book> findList3();
    List<Book> findList4();

    Book GetBookById(int id);

}
