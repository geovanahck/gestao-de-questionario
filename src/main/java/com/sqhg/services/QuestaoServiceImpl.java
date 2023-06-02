package com.sqhg.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sqhg.entities.Questao;

import com.sqhg.repositories.QuestionarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestaoServiceImpl implements QuestaoService {

    private QuestionarioRepository questaoRepository;

    @Override
    public List<Questao> obterDescricoes() {
        // List<Questao> questoes = questaoRepository.findAll();
        // return questoes.stream().collect(Collectors.toList());
        return null;
    }

}
