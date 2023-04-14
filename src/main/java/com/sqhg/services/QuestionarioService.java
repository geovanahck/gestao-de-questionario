package com.sqhg.services;

import org.springframework.stereotype.Service;

import com.sqhg.controllers.NovoModeloQuestionarioController;
import com.sqhg.entities.Questionario;
import com.sqhg.exception.QuestionarioNaoEncontradoException;
import com.sqhg.repositories.NovoModeloQuestionarioRepository;

@Service
public class QuestionarioService {
    
    private final NovoModeloQuestionarioRepository novoModeloQuestionarioRepository;

    public QuestionarioService(NovoModeloQuestionarioRepository novoModeloQuestionarioRepository) {
        this.novoModeloQuestionarioRepository = novoModeloQuestionarioRepository;
    }


    public Questionario getQuestionario(Long id) {
        return novoModeloQuestionarioRepository.findById(id).orElseThrow(() -> new QuestionarioNaoEncontradoException("Questionário não encontrado " + id));
    }
}
