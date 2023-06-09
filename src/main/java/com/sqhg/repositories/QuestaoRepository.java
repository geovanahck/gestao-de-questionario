package com.sqhg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sqhg.entities.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
    @Query("SELECT q FROM Questao q WHERE q.modeloQuestionario.id = :modeloQuestionarioId")
    Questao findByModeloQuestionarioId(@Param("modeloQuestionarioId") Long modeloQuestionarioId);
}
