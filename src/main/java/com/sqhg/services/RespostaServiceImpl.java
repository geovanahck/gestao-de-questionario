package com.sqhg.services;

import com.sqhg.entities.Resposta;
import com.sqhg.repositories.RespostaRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RespostaServiceImpl implements RespostaService {

    private final RespostaRepository respostaRepository;

    @Override
    public void salvarResposta(Resposta resposta) {
        respostaRepository.save(resposta);
    }
}
