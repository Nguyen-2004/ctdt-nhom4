package com.example.nhom4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/courses-ui")
    public String courses() {
        return "courses";
    }

    @GetMapping("/tpc-ui")
    public String tpc() {
        return "training_program_courses";
    }
}