package com.sqhg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sqhg.entities.ModeloQuestionario;

public interface NovoModeloQuestionarioRepository extends JpaRepository<ModeloQuestionario, Long> {
    ModeloQuestionario save(ModeloQuestionario modeloQuestionario);
}
