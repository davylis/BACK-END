package com.example.helloworld.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//annotations
@Controller
@ResponseBody
public class HelloController {

    //"*" No matter what user will try to call: it will give Hello Spring
    //Tells what url /endpoint the method is ran
    @RequestMapping("*")
    public String hello() {
        return "Hello Spring";
    }
    //another url /endpoint
    @RequestMapping("/bitcoin")
    public String bitcoin() {
        return "Value of bitcoin is high";
    }

    @RequestMapping("/bitcointwo")
    public String bitcointwo(@RequestParam(name="currency")String value, @RequestParam(name="time") String time) {
        return "You want to know Bitcoin price in " + value + " " + time;
    }
}
