package com.sqhg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TesteController {

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }
}
