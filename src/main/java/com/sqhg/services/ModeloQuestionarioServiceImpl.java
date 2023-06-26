package com.sqhg.services;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.repositories.ModeloQuestionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModeloQuestionarioServiceImpl implements ModeloQuestionarioService {

    private final ModeloQuestionarioRepository modeloQuestionarioRepository;

    @Override
    public void salvar(ModeloQuestionario modeloQuestionario) {
        modeloQuestionarioRepository.save(modeloQuestionario);
    }
}
