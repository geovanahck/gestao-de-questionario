package com.sqhg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sqhg.entities.ModeloQuestionario;
import com.sqhg.entities.Questionario;

public interface NovoModeloQuestionarioRepository extends JpaRepository<ModeloQuestionario, Long> {
    ModeloQuestionario save(Questionario questionario);
}
