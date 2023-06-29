package com.sqhg.services;

import com.sqhg.entities.Questao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestaoService {
    List<Questao> listarTodasQuestoes();
    Page<Questao> listarQuestoesPorPagina(Pageable pageable);
    void salvarQuestao(Questao questao);
}
