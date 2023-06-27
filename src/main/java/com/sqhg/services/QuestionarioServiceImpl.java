package com.sqhg.services;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sqhg.entities.SuperiorImediato;
import com.sqhg.repositories.QuestionarioRepository;

@Service
@AllArgsConstructor
public class QuestionarioServiceImpl implements QuestionarioService {
    private QuestionarioRepository questionarioRepository;

    @Override
    public List<SuperiorImediato> buscarSuperioresPorAreasECargos(List<String> areas, List<String> cargos) {
        return questionarioRepository.findByAreaNomeInAndCargoIn(areas, cargos);
    }

    @Override
    public void enviarQuestionario(List<SuperiorImediato> superiores) {
        
    }

}
