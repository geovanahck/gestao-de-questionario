package com.sqhg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sqhg.entities.ModeloQuestionario;

public interface NovoModeloQuestionarioRepository extends JpaRepository<ModeloQuestionario, Long> {
    @Query(value = "insert * from")
}
