package com.sqhg.views;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class AdministradorView {

    private AdministradorRepository administradorRepository;
    // Tela Cadastro de Administrador
    @GetMapping(value="/administradores")
    public String cadastrarAdministrador(Model model) {
        Administrador administrador = new Administrador();
        model.addAttribute("administrador", administrador);
        return "cadAdministrador";
    }

    @PostMapping(value = "/admninistradores")
    public String salvarAdministrador(@ModelAttribute("administrador") Administrador administrador, BindingResult result) {
        if (result.hasErrors()) {
            return "cadAdministrador";
        }
        System.out.println("FUISFIU");
        administradorRepository.save(administrador);
        return "redirect:/login";
    }

}
