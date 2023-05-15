package com.sqhg.controllers;

import com.sqhg.entities.Administrador;
import com.sqhg.forms.AdministradorForm;
import com.sqhg.repositories.AdministradorRepository;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/administradores")
@AllArgsConstructor
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
        return "redirect:/users";
    }

    @GetMapping(value = "/lista")
    public String listaAdministradores(Model model,
            @RequestParam(name = "search") Optional<String> search,
            @RequestParam(name = "pageSize") Optional<Integer> size,
            @RequestParam(name = "page") Optional<Integer> page) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);
        String keyword = search.orElse(null);
        
        if (currentPage < 0) {
            currentPage = 0;
        }

        Page<Administrador> administradorPage = administradorService
                .acharAdministradoresPorPagina(currentPage, pageSize, keyword);

        model.addAttribute("administradores", administradorPage);
        model.addAttribute("page", currentPage);
        model.addAttribute("pageSize", pageSize);
        return "listaAdm";
    }

    @GetMapping(value = "/editar/{id}")
    public String telaEditarAdministrador(Model model, @PathVariable(name = "id") Long id) {
        Administrador administrador = administradorService.acharAdministradorPorId(id).orElse(null);
        model.addAttribute("administrador", administrador);
        return "editarAdm";
    }

    @PostMapping(value = ("/editar/{id}"))
    public String editarAdministrador(@Valid @ModelAttribute("administrador") AdministradorForm administradorForm,
            BindingResult result) {
        if (result.hasErrors()) {
            return "cadAdministrador";
        }
        if (!administradorForm.getSenha().equals(administradorForm.getConfirmacaoSenha())) {
            result.rejectValue("confirmacaoSenha", "", "Senhas não correspondem.");
            return "cadAdministrador";
        }
        administradorService.salvarAdministradorPorForm(administradorForm);
        return "redirect:/users";
    }

    @GetMapping(value = ("/excluir/{id}"))
    public String deletarAdministrador(@RequestParam("id") Long id) {
        administradorService.deletar(id);
        return "redirect:/listaAdm";
    }

    @PostMapping
    public ResponseEntity<Administrador> create(@RequestBody Administrador administrador) {
        administradorService.salvarAdministrador(administrador);
        return new ResponseEntity<>(administrador, HttpStatus.CREATED);
    }
}
