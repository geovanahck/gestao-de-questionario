package com.sqhg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqhg.entities.Questao;
import com.sqhg.entities.Questionario;

public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
    List<Questao> findQuestoesByCodigo(int codigoQuestionario);
}
