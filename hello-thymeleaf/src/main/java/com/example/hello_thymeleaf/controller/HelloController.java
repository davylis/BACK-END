package com.example.hello_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/helloone")
    public String sayHello(
        @RequestParam(name = "name") String name, 
        @RequestParam(name = "age") int age, 
        Model model) {
        
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        
        return "hello";
    }
}
