package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${country.list}")
    private List<String> countriyList;
    @Value("${programming.language.list}")
    private List<String> languageList;
    @Value("${operating.system.list}")
    private List<String> systemsList;


    @GetMapping("/showStudentsForm")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countriyList);
        model.addAttribute("languages", languageList);
        model.addAttribute("systems", systemsList);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student) {
        return "student-confirmation";
    }
}
