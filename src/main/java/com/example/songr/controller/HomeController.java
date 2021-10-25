package com.example.songr.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

//    http://localhost:8080
    @GetMapping("/")
    String splash(){return "splash";}


    //     http://localhost:8080/hello
    @GetMapping("/hello")  // short form of mapping end points
    public String getRequestFunction(){
        return "hello";
    }
}
