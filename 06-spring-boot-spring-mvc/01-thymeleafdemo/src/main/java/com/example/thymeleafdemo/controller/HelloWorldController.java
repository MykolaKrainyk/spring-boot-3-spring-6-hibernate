package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(Model model) {
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm(Model model) {
        return "helloworld-show";
    }
}
