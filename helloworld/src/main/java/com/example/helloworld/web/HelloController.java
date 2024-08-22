package com.example.helloworld.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//annotations
@Controller
@ResponseBody
public class HelloController {

    //"*" No matter what user will try to call: it will give Hello Spring
    @RequestMapping("*")
    public String hello() {
        return "Hello Spring";
    }
}
