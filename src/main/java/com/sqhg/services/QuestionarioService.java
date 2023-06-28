package com.sqhg.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Questionario;
import com.sqhg.entities.SuperiorImediato;

public interface QuestionarioService {

    List<SuperiorImediato> buscarSuperioresPorAreasECargos(List<String> areas, List<String> cargos);

    String salvarQuestionario(List<SuperiorImediato> superiores, ModeloQuestionario questionario);

    Page<Questionario> acharQuestionariosPorPagina(int pageNo, int pageSize, String keyword);
}
