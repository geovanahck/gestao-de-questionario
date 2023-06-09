package com.sqhg.services;


import com.sqhg.entities.Questao;

public interface QuestaoService {
    Questao acharQuestoesPorModeloQuestionario(Long modeloquestionarioId);
}
