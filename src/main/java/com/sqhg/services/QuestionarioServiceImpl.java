package com.sqhg.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sqhg.entities.Questao;
import com.sqhg.repositories.QuestionarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionarioServiceImpl implements QuestionarioService {
    private final QuestionarioRepository questionarioRepository;

    @Override
    public List<Questao> findQuestionsByQuestionarioCodigo(int codigoQuestionario) {
        return questionarioRepository.findQuestoesByCodigo(codigoQuestionario);
    }
}
