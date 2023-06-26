package com.sqhg.services;

import com.sqhg.entities.Questao;
import java.util.List;

public interface QuestionarioService {

    List<Questao> findQuestionsByQuestionarioCodigo(int codigoQuestionario);

}
