package com.example.ereading.service;

import com.example.ereading.domain.Book;

import java.util.List;

public interface IBookService {
    List<Book> findHotList1();

    List<Book> findHotList2();

    List<Book> findHotList3();

    List<Book> findHotList4();

    List<Book> SearchList(String word);

    Book GetBookById(int id);
    List<Book> findList1();
    List<Book> findList2();
    List<Book> findList3();
    List<Book> findList4();
}
