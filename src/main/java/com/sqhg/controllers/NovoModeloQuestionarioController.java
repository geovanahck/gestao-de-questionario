package com.sqhg.controllers;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sqhg.controllers.dto.IncluirNovoModeloQuestionarioRequest;
import com.sqhg.controllers.dto.IncluirNovoModeloQuestionarioResponse;
import com.sqhg.repositories.NovoModeloQuestionarioRepository;
import com.sqhg.services.QuestionarioService;

@Controller
public class NovoModeloQuestionarioController {

    private final QuestionarioService questionarioService;
    private final ObjectMapper mapper = new ObjectMapper();
    
    @Autowired
    private NovoModeloQuestionarioRepository novoModeloQuestionarioRepository;

    @Autowired
    @GetMapping(value = "/novoModeloQuestionario")
    public String novoModeloQuestionario() {
        return "novoModeloQuestionario";
    }

    @PostMapping()
    public ResponseEntity<IncluirNovoModeloQuestionarioResponse> incluir(@RequestParam String questionarioData, @RequestParam("file") final MultipartFile file) throws IOException {

        final var incluirNovoModeloQuestionarioRequest = mapper.readValue(questionarioData, valueType:IncluirNovoModeloQuestionarioRequest.class);
        
        var questionario = questionarioService.incluir(incluirNovoModeloQuestionarioRequest);

        var questionarioResponse = new IncluirNovoModeloQuestionarioResponse();
        BeanUtils.copyProperties(questionario, questionarioResponse);
        return new ResponseEntity<>(questionarioResponse, HttpStatus.CREATED);
    }
}
