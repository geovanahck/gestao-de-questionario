package com.sqhg.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

@Controller
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class LoginController {
    @Autowired
    private AdministradorRepository administradorrepository;
    private final PasswordEncoder encoder;

    public LoginController(AdministradorRepository administradorrepository, PasswordEncoder encoder) {
        this.administradorrepository = administradorrepository;
        this.encoder = encoder;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String validarSenha(@RequestParam(required = true) String cracha,
            @RequestParam(required = true) String senha, RedirectAttributes redirectAttributes) {

        Optional<Administrador> optUsuario = administradorrepository.findByCracha(cracha);

        if (optUsuario.isEmpty()) {
            redirectAttributes.addFlashAttribute("messageerror", "Login ou senha inválido");
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
            return "redirect:/login";
        }
        Administrador adm = optUsuario.get();
        boolean valid = encoder.matches(senha, adm.getSenha());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        ResponseEntity.status(status).body(valid);
        return "redirect:/adm/lista";
    }

}