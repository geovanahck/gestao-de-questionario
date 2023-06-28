package com.sqhg.services;

import java.util.List;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.SuperiorImediato;

public interface QuestionarioService {

    List<SuperiorImediato> buscarSuperioresPorAreasECargos(List<String> areas, List<String> cargos);

    String salvarQuestionario(List<SuperiorImediato> superiores, ModeloQuestionario questionario);
}
