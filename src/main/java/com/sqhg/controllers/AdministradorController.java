package com.sqhg.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping(value = "/adm")
public class AdministradorController {

    private AdministradorRepository administradorrepository;
    private final PasswordEncoder encoder;

    @Autowired
    public AdministradorController(AdministradorRepository administradorrepository, PasswordEncoder encoder) {
        this.administradorrepository = administradorrepository;
        this.encoder = encoder;
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
    public ModelAndView irParaTelaAdministrador(@PathVariable("id") long id, RedirectAttributes redirectAttributes,
            @ModelAttribute Administrador administrador)
            throws IllegalAccessException {
        Optional<Administrador> administradorVelho = this.administradorrepository.findById(id);
        ModelAndView editarMV = new ModelAndView("editarAdm");
        ModelAndView mv = new ModelAndView("listaAdm");
        if (!administradorVelho.isPresent()) {
            redirectAttributes.addFlashAttribute("messageerror", "Administrador nao encontrado");
            mv.addObject("messageerror", redirectAttributes);
            return mv;
        }
        if (administrador.getAtivo() == true) {
            redirectAttributes.addFlashAttribute("messageerror", "Este administrador foi excluído");
            mv.addObject("messageerror", redirectAttributes);
            return mv;
        }

        Administrador admin = administradorVelho.get();
        editarMV.addObject("administrador", admin);

        return editarMV;
    }

    @PostMapping(value = ("/edicao/{id}"))
    public String editarAdministrador(@PathVariable("id") long id,
            @ModelAttribute Administrador administradorAtualizado,
            RedirectAttributes redirectAttributes, BindingResult bindingResult, String senha, String confirmacaoSenha) {

        Optional<Administrador> administradorExistente = administradorrepository.findById(id);

        Administrador administradorEditado = administradorExistente.get();
        if (administradorAtualizado.getAtivo() == false) {
            redirectAttributes.addFlashAttribute("messageerror",
                    "Administrador desativado");
            return "redirect:/adm/editar/" + id;
        }
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
            administradorrepository.save(administradorEditado);
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
        Optional<Administrador> administradorOpt = administradorrepository.findById(id);

        try {
            if (administradorOpt.isPresent()) {
                Administrador adminEncontrado = administradorOpt.get();
                adminEncontrado.setAtivo(false);
                administradorrepository.save(adminEncontrado);
                redirectAttributes.addFlashAttribute("messagesucess", "Adiministrador excluido com sucesso");
                return "redirect:/adm/lista";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/adm/lista";
    }

    @GetMapping("/Listar")
    public ResponseEntity<List<Administrador>> listarTodos() {
        return ResponseEntity.ok(administradorrepository.findAll());
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Administrador> salvar(@RequestBody Administrador responseEntity) {
        responseEntity.setSenha((encoder.encode(responseEntity.getSenha())));
        return ResponseEntity.ok(administradorrepository.save(responseEntity));
    }
}
