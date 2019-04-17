package com.tt.demo03.controller;

import com.tt.demo03.pojo.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InController {
    @RequestMapping(value = "/findBook",method = RequestMethod.POST)

    public Book findBook(@RequestBody Book book){
        System.out.println(book);

        book.setAuthor("肖文吉");
        book.setImage("java.jpg");
        book.setPrice(58.0);

        return book;
    }
    @RequestMapping("/findBooks")
    public List<Book> findBooks(){
        List<Book> books=new ArrayList<Book>();
        books.add(new Book(1,"疯狂java","java.jpg","李刚编著",109.00));
        books.add(new Book(2,"轻量级javaee企业应用实战","ee.jpg","李刚编著",108.00));
        books.add(new Book(3,"spring+mybatis应用实战","springmybatis.jpg","疯狂软件编著",58.00));
        books.add(new Book(4,"疯狂Android","android.jpg","李刚编著",108.00));
        books.add(new Book(5,"疯狂ajax开发","ajax.jpg","李刚编著",79.00));
        return books;
    }
}
