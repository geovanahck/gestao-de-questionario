package com.sqhg.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sqhg.entities.Opcao;
import com.sqhg.repositories.OpcaoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OpcaoServiceImpl implements OpcaoService {
    private final OpcaoRepository opcaoRepository;

    @Override
    public List<Opcao> findOpcoesByQuestaoId(Long questaoId) {
        return opcaoRepository.findByQuestaoId(questaoId);
    }
}
