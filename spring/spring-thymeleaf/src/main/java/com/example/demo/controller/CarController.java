package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/car")
@Controller
public class CarController {

    @GetMapping("/test")
    public String carTest() {


        return "car";
    }


}
