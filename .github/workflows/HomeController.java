package com.keyin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("message", "Hello World");
        return "index"; // This corresponds to index.html or index.thymeleaf in the templates directory
    }
}