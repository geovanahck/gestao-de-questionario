package com.sqhg.services;

import com.sqhg.entities.Administrador;
import com.sqhg.entities.Questionario;
import com.sqhg.repositories.AdministradorRepository;
import com.sqhg.repositories.QuestionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionarioService {

    private QuestionarioRepository questionarioRepository;
    public Page<Questionario> acharQuestionarioPorPagina(int pageNo, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        if (keyword == null) {
            return questionarioRepository.findAll(pageable);
        } else {
            return questionarioRepository.buscarQuestionarioPorFiltro(keyword, pageable);
        }
    }
}
