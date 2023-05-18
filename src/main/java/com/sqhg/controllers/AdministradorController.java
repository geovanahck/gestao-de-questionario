package com.sqhg.controllers;

import com.sqhg.entities.Administrador;
import com.sqhg.forms.AdministradorForm;
import com.sqhg.services.AdministradorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/administradores")
public class AdministradorController {

    private AdministradorService administradorService;

    @GetMapping(value = "/novo")
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
        administradorService.salvarAdministradorPorForm(administradorForm);
        return "redirect:/administradores/lista";
    }

    @GetMapping(value = "/lista")
    public String listaAdministradores(Model model,
            @RequestParam(name = "search") Optional<String> search,
            @RequestParam(name = "pageSize") Optional<Integer> size,
            @RequestParam(name = "page") Optional<Integer> page) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);
        String keyword = search.orElse(null);

        Page<Administrador> administradorPage = administradorService
                .acharAdministradoresPorPagina(currentPage, pageSize, keyword);

        model.addAttribute("administradores", administradorPage);
        model.addAttribute("page", currentPage);
        model.addAttribute("pageSize", pageSize);
        return "listaAdm";
    }

    @GetMapping(value = "/editar/{id}")
    public Administrador telaEditarAdministrador(@PathVariable(name = "id") Long id) {
        Administrador administrador = administradorService.acharAdministradorPorId(id).orElse(null);

        AdministradorForm administradorForm = administrador.getForm();
        // model.addAttribute("administrador", administradorForm);
        return administrador;
    }

    @PostMapping(value = ("/editar/{id}"))
    public String editarAdministrador(@PathVariable(name = "id") Long id,
            @Valid @ModelAttribute("administrador") AdministradorForm administradorForm,
            BindingResult result) {
        if (result.hasErrors()) {
            return "editarAdm";
        }
        if (!administradorForm.getSenha().equals(administradorForm.getConfirmacaoSenha())) {
            result.rejectValue("confirmacaoSenha", "", "Senhas não correspondem.");
            return "editarAdm";
        }
        if (!administradorForm.getSenha().equals(administradorForm.getConfirmacaoSenha())) {
            result.rejectValue("confirmacaoSenha", "", "Senhas não correspondem.");
            return "cadAdministrador";
        }
        administradorService.salvarAdministradorPorForm(administradorForm);
        return "redirect:/administradores/lista";
    }

    @PostMapping(value = ("/excluir/{id}"))
    public String deletarAdministrador(@PathVariable("id") Long id) {
        administradorService.deletar(id);
        return "redirect:/administradores/lista";
    }

    @PostMapping
    public ResponseEntity<Administrador> create(@RequestBody Administrador administrador) {
        administradorService.salvarAdministrador(administrador);
        return new ResponseEntity<>(administrador, HttpStatus.CREATED);
    }
}
