package com.sqhg.services;

import org.springframework.stereotype.Service;

import com.sqhg.entities.Questao;
import com.sqhg.repositories.QuestaoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestaoServiceImpl implements QuestaoService {
    private QuestaoRepository questaoRepository;

    @Override
    public Questao acharQuestoesPorModeloQuestionario(Long idModeloQuestionario) {
        Questao questao = questaoRepository.findByModeloQuestionarioId(idModeloQuestionario);
        return questao;
    }

}
