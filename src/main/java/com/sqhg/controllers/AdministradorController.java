package com.sqhg.controllers;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;
import com.sqhg.services.AdministradorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/administradores")
@AllArgsConstructor
public class AdministradorController {

    private AdministradorService administradorService;

    @GetMapping(value = "/lista")
    // retornar pagina de administradores com quantidade de administradores e filtro
    public String listaAdministradores(Model model,
            @RequestParam(name = "search") Optional<String> search,
            @RequestParam(name = "size") Optional<Integer> size,
            @RequestParam(name = "page") Optional<Integer> page) {

        int currentPage = page.orElse(1) - 1;
        int pageSize = page.orElse(10);
        String keyword = search.orElse(null);

        Page<Administrador> administradorPage = administradorService
                .acharAdministradoresPorPagina(currentPage, pageSize, keyword);
        List<Integer> pages = IntStream.rangeClosed(1, administradorPage.getTotalPages()).boxed().toList();

        model.addAttribute("administradorPage", administradorPage);
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);

        return "listaAdm";
    }

    @GetMapping(value = "/editar/{id}")
    public String telaEditarAdministrador(Model model, @RequestParam(name = "id") Long id) {
        Administrador administrador = administradorService.acharAdministradorPorId(id).orElse(null);
        model.addAttribute("administrador", administrador);
        return "editarAdm";
    }

    @PostMapping(value = ("/editar/{id}"))
    public String editarAdministrador(@ModelAttribute("administrador") Administrador administrador) {
        return null;
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
