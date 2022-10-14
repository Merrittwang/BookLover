package com.example.ereading.service;

import com.example.ereading.domain.Book;
import com.example.ereading.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class BookService {
    @Resource
    private BookMapper bookMapper;

    public String GetBookName(Integer id) {
        return bookMapper.getBookName(id);
    }
    public String GetAuthorName(Integer id) {return bookMapper.getAuthorName(id);}

    public  Book Getall(Integer id) {
        Book B=new Book();
        B.setBook_name(GetBookName(id));
        B.setAuthor(GetAuthorName(id));
        return B;
    }
}
