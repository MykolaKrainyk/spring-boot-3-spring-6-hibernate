package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam("studentName") String name, Model model) {
        String result = "Hey My Friend! " + name.toUpperCase();
        model.addAttribute("message", result);

        return "helloworld";
    }
}
