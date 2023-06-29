package com.sqhg.services;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.Page;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Questionario;
import com.sqhg.entities.SuperiorImediato;

public interface QuestionarioService {

    List<SuperiorImediato> buscarSuperioresPorAreasECargos(List<String> areas, List<String> cargos);

    String salvarQuestionario(List<SuperiorImediato> superiores, ModeloQuestionario questionario, Date dataInicio,
            Date dataFim, LocalTime horaInicio, LocalTime horaFim);

    Page<Questionario> acharQuestionariosPorPagina(int pageNo, int pageSize, String keyword);
}
