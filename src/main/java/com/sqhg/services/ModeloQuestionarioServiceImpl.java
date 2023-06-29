package com.sqhg.services;

import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.repositories.ModeloQuestionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModeloQuestionarioServiceImpl implements ModeloQuestionarioService {

    private final ModeloQuestionarioRepository modeloQuestionarioRepository;

    @Override
    public Page<ModeloQuestionario> buscarModeloQuestionarioPorPagina(int pageNo, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        if (keyword == null) {
            return modeloQuestionarioRepository.findAll(pageable);
        } else {
            return modeloQuestionarioRepository.buscarModeloQuestionarioPorFiltro(keyword, pageable);
        }
    }
}
