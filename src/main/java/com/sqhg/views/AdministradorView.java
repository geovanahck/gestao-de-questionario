package com.sqhg.views;

import com.sqhg.entities.Administrador;
import com.sqhg.forms.AdministradorForm;
import com.sqhg.services.AdministradorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/administradores")
@AllArgsConstructor
public class AdministradorView {

    private AdministradorService administradorService;

    @GetMapping(value="/novo")
    public String cadastrarAdministrador(Model model) {
        model.addAttribute("administrador", new AdministradorForm());
        return "cadAdministrador";
    }

    @PostMapping(value = "/novo")
    public String salvarAdministrador(@Valid @ModelAttribute("administrador") AdministradorForm administradorForm,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "cadAdministrador";
        }
        if (!administradorForm.getSenha().equals(administradorForm.getConfirmacaoSenha())) {
            result.rejectValue("confirmacaoSenha", "", "Senhas não correspondem.");
            return "cadAdministrador";
        }
        Administrador administrador = new Administrador();
        administrador.setCracha(administradorForm.getCracha());
        administrador.setNome(administradorForm.getNome());
        administrador.setEmail(administradorForm.getEmail());
        administrador.setTelefone(administradorForm.getTelefone());
        administrador.setSenha(administradorForm.getSenha());

        administradorService.salvarAdministrador(administrador);
        return "redirect:/users";
    }
}
