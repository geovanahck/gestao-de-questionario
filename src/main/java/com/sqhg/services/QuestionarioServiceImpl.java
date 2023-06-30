package com.sqhg.services;

import org.springframework.stereotype.Service;

import com.sqhg.entities.Questionario;
import com.sqhg.repositories.QuestionarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionarioServiceImpl implements QuestionarioService {

    private final QuestionarioRepository questionarioRepository;

    public Questionario acharQuestionarioPorCodigo(Integer codigoQuestionario) {
        return questionarioRepository.findByCodigo(codigoQuestionario).orElse(null);
    }
}
