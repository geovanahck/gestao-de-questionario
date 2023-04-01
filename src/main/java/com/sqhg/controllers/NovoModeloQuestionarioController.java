package com.sqhg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.repositories.NovoModeloQuestionarioRepository;

@Controller
public class NovoModeloQuestionarioController {
    
    @Autowired
    private NovoModeloQuestionarioRepository repositoyNovoModeloQuestionario;

    @Autowired
    public void inserirNovoModeloQuestionario() {
        ModeloQuestionario novoModeloQuestionario = new ModeloQuestionario();
        novoModeloQuestionario.setNome("Maria");
        novoModeloQuestionario.setDescricao("xxx");
       // pessoaRepository.save(pessoa);

    @GetMapping(value = "/novoModeloQuestionario")
    public String novoModeloQuestionario() {
        return "novoModeloQuestionario";
    }
    
    @PostMapping
    public void createNovoModeloQuestionario(@RequestBody ModeloQuestionario novoModeloQuestionario) {
        
    }
}
}
