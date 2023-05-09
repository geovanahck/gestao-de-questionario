package com.sqhg.controllers;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqhg.controllers.dto.AtualizarModeloQuestionarioRequest;
import com.sqhg.controllers.dto.IncluirNovoModeloQuestionarioRequest;
import com.sqhg.controllers.dto.IncluirNovoModeloQuestionarioResponse;
import com.sqhg.model.QuestionarioModel;
import com.sqhg.services.QuestionarioService;

@Controller
public class NovoModeloQuestionarioController {

    private final QuestionarioService questionarioService;
    private final ObjectMapper mapper = new ObjectMapper();

    public NovoModeloQuestionarioController(QuestionarioService questionarioService) {
        this.questionarioService = questionarioService;
    }

    @Autowired
    @GetMapping(value = "/novoModeloQuestionario")
    public String novoModeloQuestionario() {
        return "novoModeloQuestionario";
    }

    @PostMapping()
    public ResponseEntity<IncluirNovoModeloQuestionarioResponse> incluir(
        @RequestParam String questionarioData, 
        @RequestParam("file") final MultipartFile file) throws IOException {

        final var incluirNovoModeloQuestionarioRequest = mapper.readValue(
            questionarioData, IncluirNovoModeloQuestionarioRequest.class);
        
        var questionario = questionarioService.incluir(incluirNovoModeloQuestionarioRequest);

        var questionarioResponse = new IncluirNovoModeloQuestionarioResponse();
        BeanUtils.copyProperties(questionario, questionarioResponse);
        return new ResponseEntity<>(questionarioResponse, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<QuestionarioModel> atualizar(@RequestParam String questionarioData,
            @RequestParam(value = "file", required = false) final MultipartFile file) throws IOException {
        final var atualizarQuestionarioRequest = mapper.readValue(questionarioData, AtualizarModeloQuestionarioRequest.class);

        if (file != null) {
           atualizarQuestionarioRequest.setNomeQuestionario(questionarioData);
        }

       var questionario = questionarioService.atualizar(atualizarQuestionarioRequest);
      // return new ResponseEntity<>(questionario, HttpStatus.OK);
       return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        questionarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
