package com.sqhg.services;

import com.sqhg.entities.Administrador;
import com.sqhg.entities.Questionario;
import com.sqhg.repositories.QuestionarioRepository;

public class QuestionarioServiceImpl implements QuestionarioService {
    private QuestionarioRepository questionarioRepository;

    public Administrador obterAdministradorDoQuestionario(Long Id) {
        Questionario questionario = questionarioRepository.findById(Id).orElse(null);

        if (questionario != null) {
            return questionario.getAdministrador();
        }
        return null;
    }
}
