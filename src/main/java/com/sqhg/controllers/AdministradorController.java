package com.sqhg.controllers;

import com.sqhg.entities.Administrador;
import com.sqhg.forms.AdministradorForm;
import com.sqhg.services.AdministradorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Calendar;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/administradores")
public class AdministradorController {

    private AdministradorService administradorService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

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
        Administrador administrador = administradorService.acharAdministradorPorCracha(administradorForm.getCracha());
        Calendar minimumDate = Calendar.getInstance();
        minimumDate.set(1900, Calendar.JANUARY, 1);

        if (administradorForm.getNascimento() != null) {
            if (administradorForm.getNascimento().before(minimumDate.getTime())) {
                result.rejectValue("nascimento", "", "* Data não pode ser anterior a 1900");
                return "cadAdministrador";
            }
        }
        if (administrador != null && administradorForm.getCracha().equals(administrador.getCracha())) {
            result.rejectValue("cracha", "", "Crachá já existente");
            return "cadAdministrador";
        }
        if (!administradorForm.getSenha().equals(administradorForm.getConfirmacaoSenha())) {
            result.rejectValue("confirmacaoSenha", "", "Senhas não correspondem");
            return "cadAdministrador";
        }
        administradorService.salvarAdministradorPorForm(administradorForm);
        return "redirect:/administradores";

    }

    @GetMapping
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
        model.addAttribute("search", keyword);
        return "listaAdm";
    }

    @GetMapping(value = "/editar/{id}")
    public String telaEditarAdministrador(Model model, @PathVariable(name = "id") Long id) {
        Administrador administrador = administradorService.findbyId(id);

        if (administrador == null) {
            return "redirect:/administradores";
        }

        AdministradorForm administradorForm = administrador.getForm();
        model.addAttribute("administrador", administradorForm);
        return "editarAdm";
    }

    @PostMapping(value = ("/editar/{id}"))
    public String editarAdministrador(
            @Valid @ModelAttribute("administrador") AdministradorForm administradorForm,
            BindingResult result,
            @PathVariable(name = "id") Long id) {
        if (result.hasErrors()) {
            return "editarAdm";
        }
        Calendar minimumDate = Calendar.getInstance();
        minimumDate.set(1900, Calendar.JANUARY, 1);
        Administrador administrador = administradorService.acharAdministradorPorCracha(administradorForm.getCracha());
        if (administradorForm.getNascimento() != null) {
            if (administradorForm.getNascimento().before(minimumDate.getTime())) {
                result.rejectValue("nascimento", "", "* Data inválida");
                return "editarAdm";
            }
        }
        if (!administradorForm.getId().equals(administrador.getId())) {
            if (administradorForm.getCracha().equals(administrador.getCracha())) {
                result.rejectValue("cracha", "", "Crachá já existente");
                return "editarAdm";
            }
        }
        if (!administradorForm.getSenha().equals(administradorForm.getConfirmacaoSenha())) {
            result.rejectValue("confirmacaoSenha", "", "Senhas não correspondem.");
            return "editarAdm";
        }
        administradorService.editarAdministradorPorForm(administradorForm, id);
        return "redirect:/administradores";

    }

    @PostMapping(value = ("/excluir/{id}"))
    public String deletarAdministrador(@PathVariable("id") Long id) {
        administradorService.deletar(id);
        return "redirect:/administradores";
    }

    @GetMapping(value = "/menu")
    public String menu(Model model) {
        return "menu";
    }

}
