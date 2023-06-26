package com.sqhg.repositories;

import com.sqhg.entities.ModeloQuestionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloQuestionarioRepository extends JpaRepository<ModeloQuestionario, Long> {
}
