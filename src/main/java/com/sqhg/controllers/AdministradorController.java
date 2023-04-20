package com.sqhg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;
import com.sqhg.service.AdministradorService;

@RestController
@RequestMapping(value = "/adm")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorrepository;

    // retornar somente os ativos na model para lista de administradores
    @GetMapping(value = "Ativos")
    public ModelAndView listAllActives(@RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Administrador> administradores = this.administradorrepository.findAllActives(pageable);
        ModelAndView modelAndView = new ModelAndView("listaAdm");
        modelAndView.addObject("administradores", administradores);
        return modelAndView;
    }

    // retornar pagina de administradores com quantidade de administradores e filtro
    @GetMapping(value = "administradores")
    public ModelAndView findAdministrador(@RequestParam(required = false) String Param,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Administrador> administradores = this.administradorrepository.findAll(pageable);
        ModelAndView mv = new ModelAndView("listaAdm");

        if (Param == null) {
            administradores = this.administradorrepository.findAllActives(pageable);
        } else {
            administradores = this.administradorrepository.buscarAdministradoresPorFiltro(Param, pageable);
        }

        int quantidadeExibida = administradores.getNumberOfElements();
        long quantidadeTotal = administradores.getTotalElements();

        mv.addObject("administradores", administradores);
        mv.addObject("page", page);
        mv.addObject("pageSize", size);
        mv.addObject("quantidadeExibida", quantidadeExibida);
        mv.addObject("quantidadeTotal", quantidadeTotal);
        mv.addObject(HttpStatus.OK);
        return mv;

    }

    @PostMapping(value = "/editar/{id}")
    public ModelAndView editarAdministrador(@PathVariable ("id") long id) {
        Administrador administrador = AdministradorService.buscarPorId(id);
        ModelAndView editarAdministrador = new ModelAndView("editarAdm");
        editarAdministrador.addObject("administrador", administrador);
        ResponseEntity.ok().body(administrador);
        return editarAdministrador;
    }
}
