package com.example.ereading.controller;

import com.example.ereading.domain.Book;
import com.example.ereading.service.BookService;
import com.example.ereading.service.IBookService;
import com.example.ereading.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController extends BaseController{
    @Resource
    BookService BookService;
    @Autowired
    private IBookService bookService;
    @RequestMapping("hot_list1")
    public JsonResult<List<Book>> getHotList1(){
        List<Book> data = bookService.findHotList1();
        System.out.println(data.get(1).getPoints());
        return new JsonResult<List<Book>>(OK, data);
    }

    @RequestMapping("hot_list2")
    public JsonResult<List<Book>> getHotList2(){
        List<Book> data = bookService.findHotList2();
        return new JsonResult<List<Book>>(OK, data);
    }

    @RequestMapping("hot_list3")
    public JsonResult<List<Book>> getHotList3(){
        List<Book> data = bookService.findHotList3();
        return new JsonResult<List<Book>>(OK, data);
    }

    @RequestMapping("hot_list4")
    public JsonResult<List<Book>> getHotList4(){
        List<Book> data = bookService.findHotList4();
        return new JsonResult<List<Book>>(OK, data);
    }

    @RequestMapping("search")
    public JsonResult<List<Book>> SearchList(
            @RequestParam(value = "title",required = false)String bookName,
            @RequestParam(value = "author",required = false)String author,
            @RequestParam(value = "category",required = false)String category,
            @RequestParam(value = "years",required = false)Long years){
        List<Book> data = bookService.SearchList(bookName,author,category,years);
        return new JsonResult<List<Book>>(OK, data);
    }

    @RequestMapping("bookId")
    public JsonResult<Book> getByBookId(@RequestParam("id") Integer id) {
        Book data = bookService.GetBookById(id);
        return new JsonResult<Book>(OK, data);
    }
}
