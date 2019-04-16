package com.tt.demo03.controller;

import com.tt.demo03.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebResult;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @RequestMapping("/test01")
    public String test01(HttpServletRequest request) {
        System.out.println(request.getParameter("name"));
        return "success01";
    }

    @RequestMapping("/test02")
    private String test02(WebRequest webRequest) {
        webRequest.setAttribute("age", "17", webRequest.SCOPE_REQUEST);
        webRequest.setAttribute("name", "张无忌", webRequest.SCOPE_REQUEST);
        webRequest.setAttribute("teacher", "韦小宝", webRequest.SCOPE_REQUEST);
        webRequest.setAttribute("student", "杨过", webRequest.SCOPE_REQUEST);
        return "success02";
    }

    @RequestMapping("/test03")
    public String test03(WebRequest webRequest) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "疯狂java", "java.jpg", "李刚编著", 109.00));
        books.add(new Book(2, "轻量级javaee企业应用实战", "ee.jpg", "李刚编著", 108.00));
        books.add(new Book(3, "spring+mybatis应用实战", "springmybatis.jpg", "疯狂软件编著", 58.00));
        books.add(new Book(4, "疯狂Android", "android.jpg", "李刚编著", 108.00));
        books.add(new Book(5, "疯狂ajax开发", "ajax.jpg", "李刚编著", 79.00));
        webRequest.setAttribute("books", books, webRequest.SCOPE_REQUEST);
        return "success03";
    }

    @RequestMapping("/in")
    public String in() {
        return "in";
    }

    @RequestMapping(value = "/getjson")
    public String getjson() {
        return "getjson";
    }
    @RequestMapping("/file")
    public String file(){
        return "file";
    }
    //上传文件会自动绑定到MultipartFile中
    @PostMapping(value = "/upload")
    public String unload(HttpServletRequest request, @RequestParam("description")String description
    , @RequestParam("file")MultipartFile file)throws Exception{
        if (!file.isEmpty()){
            //上传文件路径
            String path=request.getServletContext().getRealPath("/unload/");
            //上传文件名
            String filename=file.getOriginalFilename();
            File filepath=new File(path,filename);
            //判断文件是否存在，不存在就创建一个
            if (!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //将文件保存到一个目录中
            //文件分隔符File.separator（/）
            file.transferTo(new File(path+File.separator+filename));
            return "file/success";
        }else {
            return "file/error";
        }
    }

}
