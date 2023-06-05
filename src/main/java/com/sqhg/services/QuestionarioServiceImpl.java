package com.sqhg.services;

import org.springframework.stereotype.Service;
import com.sqhg.entities.Questionario;
import com.sqhg.repositories.QuestionarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionarioServiceImpl implements QuestionarioService {
    private QuestionarioRepository questionarioRepository;


    @Override
    public Questionario findById(Long modeloquestionarioId) {
        return questionarioRepository.findById(modeloquestionarioId).orElse(null);
    }
}
