package com.sqhg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/cadadministrador")
    public String cadadministrador() { return "cadAdministrador";  }

    @GetMapping("/listaadm")
    public String listadm() { return "listaAdm";  }



}
