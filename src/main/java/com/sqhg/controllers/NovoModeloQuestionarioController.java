package com.sqhg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.repositories.NovoModeloQuestionarioRepository;

@Controller
public class NovoModeloQuestionarioController {
    
    @Autowired
    private NovoModeloQuestionarioRepository novoModeloQuestionarioRepository;

    @Autowired
    @GetMapping(value = "/novoModeloQuestionario")
    public String novoModeloQuestionario() {
        return "novoModeloQuestionario";
    }

    @PostMapping("/novoModeloQuestionario")
    public String inserirNovoModeloQuestionario(@ModelAttribute("modeloQuestionario")ModeloQuestionario novoModeloQuestionario, Model model) {
        novoModeloQuestionarioRepository.save(novoModeloQuestionario);
        model.addAttribute("Questionário gravado com sucesso!");
        return "novoModeloQuestionario"; 
}
}