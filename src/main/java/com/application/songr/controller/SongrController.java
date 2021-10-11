package com.application.songr.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class SongrController {


    @GetMapping("/")
    public String basicPage(){
        return "basic";
    }

    @GetMapping("/hello")
    public String greeting(Model model) {
        model.addAttribute("message","Hello World");
        return "hello-world";
    }

    @GetMapping("/capitalize/{name}")
    public String gitUserInfo(@PathVariable String name,Model model){
        model.addAttribute("name",name.toUpperCase());
        return "capitalize";
    }


}
