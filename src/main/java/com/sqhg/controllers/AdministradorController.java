package com.sqhg.controllers;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;
import com.sqhg.services.AdministradorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/administradores")
@AllArgsConstructor
public class AdministradorController {

    private AdministradorRepository administradorRepository;
    private AdministradorService administradorService;

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
            Page<Administrador> administradores = this.administradorRepository.findAllActives(pageable);
            long quantidadeTotal = administradores.getTotalElements();
            int quantidadeExibida;
            int totalPages = administradores.getTotalPages();
            System.out.println(totalPages);

            if ((page + 1) >= totalPages) {
                page = (totalPages - 1);
                pageable = PageRequest.of(page, size);
                quantidadeExibida = administradores.getNumberOfElements();
                quantidadeTotal = administradores.getTotalElements();
            }
            if (Search == null) {
                administradores = this.administradorRepository.findAllActives(pageable);
            } else {
                administradores = this.administradorRepository.buscarAdministradoresPorFiltro(Search, pageable);
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
    public ModelAndView irParaTelaAdministrador(@PathVariable("id") long id, RedirectAttributes redirectAttributes,
            @ModelAttribute Administrador administrador)
            throws IllegalAccessException {
        Optional<Administrador> administradorVelho = this.administradorRepository.findById(id);
        ModelAndView editarMV = new ModelAndView("editarAdm");
        if (administrador.getAtivo()) {
            redirectAttributes.addFlashAttribute("messageerror", "Este administrador foi excluído");
            editarMV.addObject("messageerror", redirectAttributes);
        }

        Administrador admin = administradorVelho.get();
        editarMV.addObject("administrador", admin);
        return editarMV;
    }

    @PostMapping(value = ("/edicao/{id}"))
    public String editarAdministrador(@PathVariable("id") long id,
            @ModelAttribute Administrador administradorAtualizado,
            RedirectAttributes redirectAttributes, BindingResult bindingResult, String senha, String confirmacaoSenha) {

        Optional<Administrador> administradorExistente = administradorRepository.findById(id);

        Administrador administradorEditado = administradorExistente.get();

        try {
            if (administradorAtualizado.getCracha() != null) {
                administradorEditado.setCracha(administradorAtualizado.getCracha());
            }

            if (administradorAtualizado.getNome() != null) {
                administradorEditado.setNome(administradorAtualizado.getNome());
            }

            if (administradorAtualizado.getEmail() != null) {
                administradorEditado.setEmail(administradorAtualizado.getEmail());
            }
            if (administradorAtualizado.getSenha() != null && administradorAtualizado.getSenha() == confirmacaoSenha) {
                administradorEditado.setSenha(administradorAtualizado.getSenha());
            }
            System.out.println(confirmacaoSenha);
            if (administradorAtualizado.getTelefone() != null) {
                administradorEditado.setTelefone(administradorAtualizado.getTelefone());
            }
            if (administradorAtualizado.getNascimento() != null) {
                try {
                    administradorEditado.setNascimento(administradorAtualizado.getNascimento());
                } catch (Exception e) {
                    redirectAttributes.addFlashAttribute("messageerror",
                            "Verifique se os campos estão preenchidos corretamente");
                    return "redirect:/adm/editar/" + id;
                }
            }
            administradorRepository.save(administradorEditado);
            ResponseEntity.ok().body(administradorEditado);
            redirectAttributes.addFlashAttribute("messagesucess", "Administrador editado com sucesso!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("messageerror",
                    "Verifique se os campos estão preenchidos corretamente");
            return "redirect:/adm/editar/" + id;
        }
        return "redirect:/adm/editar/" + id;
    }

    @GetMapping(value = ("/excluir/{id}"))
    public String excluirAdministrador(@PathVariable("id") long id,
            @ModelAttribute Administrador administradorExcluir,
            RedirectAttributes redirectAttributes) {
        Optional<Administrador> administradorOpt = administradorRepository.findById(id);

        try {
            if (administradorOpt.isPresent()) {
                Administrador adminEncontrado = administradorOpt.get();
                adminEncontrado.setAtivo(false);
                administradorRepository.save(adminEncontrado);
                redirectAttributes.addFlashAttribute("messagesucess", "Adiministrador excluido com sucesso");
                return "redirect:/adm/lista";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/adm/lista";
    }

    @PostMapping
    public ResponseEntity<Administrador> create(@RequestBody Administrador administrador) {
        administradorService.salvarAdministrador(administrador);
        return new ResponseEntity<>(administrador, HttpStatus.CREATED);
    }
}
