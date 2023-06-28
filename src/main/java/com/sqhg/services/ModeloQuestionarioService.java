package com.sqhg.services;

import com.sqhg.entities.ModeloQuestionario;
import org.springframework.data.domain.Page;

public interface ModeloQuestionarioService {

    Page<ModeloQuestionario> buscarModeloQuestionarioPorPagina(int pageNo, int pageSize, String keyword);
}
