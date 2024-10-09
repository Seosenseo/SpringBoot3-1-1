package com.example.springtask311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hi!");
        messages.add("SpringBoot CRUD application");
        messages.add("0.0.1 version by sep'31 ");
        model.addAttribute("messages", messages);
        return "startpage";
    }
}
