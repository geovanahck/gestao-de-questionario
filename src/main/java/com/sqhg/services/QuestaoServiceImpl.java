package com.sqhg.services;

import com.sqhg.entities.Questao;
import com.sqhg.repositories.QuestaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestaoServiceImpl implements QuestaoService {

    private final QuestaoRepository questaoRepository;

    @Override
    public List<Questao> listarTodasQuestoes() {
        return questaoRepository.findAll();
    }

    @Override
    public Page<Questao> listarQuestoesPorPagina(Pageable pageable) {
        return questaoRepository.findAll(pageable);
    }

    @Override
    public void salvarQuestao(Questao questao) {
        questaoRepository.save(questao);
    }
}
