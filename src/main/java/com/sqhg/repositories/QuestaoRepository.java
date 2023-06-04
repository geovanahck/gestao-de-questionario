package com.sqhg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqhg.entities.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

    List<Questao> findByModeloQuestionarioId(Long idModeloQuestionario);

}
