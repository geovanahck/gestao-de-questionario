package com.sqhg.controllers;

import java.sql.Date;
import java.util.Optional;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

@RestController
@RequestMapping(value = "/adm")
public class AdministradorController {

    private AdministradorRepository administradorrepository;

    @Autowired
    public AdministradorController(AdministradorRepository administradorrepository) {
        this.administradorrepository = administradorrepository;
    }

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

            mv.addObject("totalPages", totalPages);
            mv.addObject("administradores", administradores);
            mv.addObject("page", page);
            mv.addObject("pageSize", size);
            mv.addObject("quantidadeExibida", quantidadeExibida = administradores.getNumberOfElements());
            mv.addObject("quantidadeTotal", quantidadeTotal);
            mv.addObject(HttpStatus.OK);
        } catch (Exception e) {
            mv.addObject("message", e.getMessage());
            System.out.println(e);
        }
        return mv;
    }

    @GetMapping(value = "/editar/{id}")
    public ModelAndView irParaTelaAdministrador(@PathVariable("id") long id, Administrador administrador)
            throws IllegalAccessException {
        Optional<Administrador> administradorVelho = this.administradorrepository.findById(id);

        if (!administradorVelho.isPresent()) {
            throw new IllegalAccessException("usuário inválido");
        }
        Administrador admin = administradorVelho.get();
        System.out.println(id);
        ModelAndView editarMV = new ModelAndView("editarAdm");
        editarMV.addObject("administrador", admin);
        return editarMV;
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String atualizarAdministrador(@PathVariable("id") Long id,
            @Valid @RequestBody Administrador administradorAtualizado, BindingResult result) {
        Optional<Administrador> administradorExistente = administradorrepository.findById(id);
        if (!administradorExistente.isPresent()) {
            ResponseEntity.notFound().build();
            return "editarAdm";
        }
        Administrador administradorAntigo = administradorExistente.get();

        if (result.hasErrors()) {
            ResponseEntity.badRequest().build();
            return "editarAdm";
        }

        administradorAntigo.setCracha(administradorAtualizado.getCracha());
        administradorAntigo.setNome(administradorAtualizado.getNome());
        administradorAntigo.setNascimento(administradorAtualizado.getNascimento());
        administradorAntigo.setEmail(administradorAtualizado.getEmail());
        administradorAntigo.setTelefone(administradorAtualizado.getTelefone());
        Administrador administradorSalvo = administradorrepository.save(administradorAntigo);

        ResponseEntity.ok(administradorSalvo);
        return "redirect:/listarAdm";
    }

}
