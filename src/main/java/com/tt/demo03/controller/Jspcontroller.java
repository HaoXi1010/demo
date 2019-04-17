package com.tt.demo03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Jspcontroller {
    @RequestMapping("/jsp")
    public String index(){
        return "test";
    }
}
