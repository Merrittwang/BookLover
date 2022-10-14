package com.example.ereading.service.implementation;

import com.example.ereading.domain.Book;
import com.example.ereading.mapper.BookMapper;
import com.example.ereading.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImplementation implements IBookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findHotList1(){
        List<Book> list = bookMapper.findHotList1();
        System.out.println(list);
        return list;
    }

    @Override
    public List<Book> findHotList2(){
        List<Book> list = bookMapper.findHotList2();
        System.out.println(list);
        return list;
    }

    public List<Book> findHotList3(){
        List<Book> list = bookMapper.findHotList3();
        System.out.println(list);
        return list;
    }

    public List<Book> findHotList4(){
        List<Book> list = bookMapper.findHotList4();
        System.out.println(list);
        return list;
    }


    @Override
    public List<Book> SearchList(String bookName,String author,String category,int years){
        List<Book> list = bookMapper.SearchList(bookName,author,category,years);
        System.out.println(list);
        return list;
    }

    @Override
    public Book GetBookById(int id){
        Book book = bookMapper.GetBookById(id);
        System.out.println(book);
        return book;
    }

    @Override
    public List<Book> findList1(){
        List<Book> list = bookMapper.findList1();
        System.out.println(list);
        return list;
    }

    @Override
    public List<Book> findList2(){
        List<Book> list = bookMapper.findList2();
        System.out.println(list);
        return list;
    }
    @Override
    public List<Book> findList3(){
        List<Book> list = bookMapper.findList3();
        System.out.println(list);
        return list;
    }
    @Override
    public List<Book> findList4(){
        List<Book> list = bookMapper.findList4();
        System.out.println(list);
        return list;
    }
}
