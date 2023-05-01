package com.sqhg.views;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;
import com.sqhg.services.AdministradorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@AllArgsConstructor
public class AdministradorView {

    private AdministradorService administradorService;

    // Tela Cadastro de Administrador
    @GetMapping(value="/administradores")
    public String cadastrarAdministrador(Model model) {
        Administrador administrador = new Administrador();
        model.addAttribute("administrador", administrador);
        return "cadAdministrador";
    }

    @PostMapping(value = "/administradores")
    public String salvarAdministrador(@ModelAttribute("administrador") Administrador administrador, BindingResult result) {
        if (result.hasErrors()) {
            return "cadAdministrador";
        }
        administradorService.salvarAdministrador(administrador);
        return "redirect:/login";
    }
}
