package com.sqhg.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.sqhg.entities.Questao;
import com.sqhg.repositories.QuestaoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestaoServiceImpl implements QuestaoService {

    private QuestaoRepository questaoRepository;

    @Override
    public List<Questao> encontrarQuestoesPorModeloQuestionario(Long idModeloQuestionario) {
        List<Questao> questoes = questaoRepository.findByModeloQuestionarioId(idModeloQuestionario);
        return questoes.stream().collect(Collectors.toList());
    }
}
