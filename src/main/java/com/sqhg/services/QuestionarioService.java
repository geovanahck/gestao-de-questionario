package com.sqhg.services;

import java.util.List;

import com.sqhg.entities.SuperiorImediato;

public interface QuestionarioService {

    List<SuperiorImediato> buscarSuperioresPorAreasECargos(List<String> orElse, List<String> orElse2);

    void enviarQuestionario(List<SuperiorImediato> superiores);
}
