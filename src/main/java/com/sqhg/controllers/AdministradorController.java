package com.sqhg.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @GetMapping(value = "/lista")
    // retornar pagina de administradores com quantidade de administradores e filtro
    public ModelAndView findAdministrador(@RequestParam(required = false) String Search,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) {

        if (page <= 0) {
            page = 0;
        }
        ModelAndView mv = new ModelAndView("listaAdm");
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Administrador> administradores = this.administradorrepository.findAllActives(pageable);
            long quantidadeTotal = administradores.getTotalElements();
            int quantidadeExibida = administradores.getNumberOfElements();
            int totalPages = administradores.getTotalPages();
            System.out.println(totalPages);

            if ((page + 1) >= totalPages) {
                page = (totalPages - 1);
                pageable = PageRequest.of(page, size);
                quantidadeExibida = administradores.getNumberOfElements();
                quantidadeTotal = administradores.getTotalElements();
            }
            if (Search == null) {
                administradores = this.administradorrepository.findAllActives(pageable);
            } else {
                administradores = this.administradorrepository.buscarAdministradoresPorFiltro(Search, pageable);
            }

            mv.addObject("totalPages", totalPages = administradores.getTotalPages());
            mv.addObject("administradores", administradores);
            mv.addObject("page", page);
            mv.addObject("pageSize", size);
            mv.addObject("quantidadeExibida", quantidadeExibida = administradores.getNumberOfElements());
            mv.addObject("quantidadeTotal", quantidadeTotal = administradores.getTotalElements());
            mv.addObject(HttpStatus.OK);
        } catch (Exception e) {
            mv.addObject("message", e.getMessage());
            System.out.println(e);
        }
        return mv;
    }

    @GetMapping(value = "/editar/{id}")
    public ModelAndView editarAdministrador(@PathVariable("id") int id) {
        Administrador administrador = this.administradorrepository.buscarID(id);
        ModelAndView editarAdministrador = new ModelAndView("editarAdm");
        editarAdministrador.addObject("administrador", administrador);
        return editarAdministrador;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/desativar", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setarAtivoFalso(@PathVariable (required = false) String Id) {
        // Atualiza o atributo "ativo" para false na sua entidade
        System.out.println(Id);
        // Optional<Administrador> administrador = this.administradorrepository.findById(Id);
        // System.out.println(administrador);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
