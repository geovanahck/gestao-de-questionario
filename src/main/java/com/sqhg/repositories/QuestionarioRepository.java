package com.sqhg.repositories;

import com.sqhg.entities.Administrador;
import com.sqhg.entities.Questionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
    @Query("SELECT q FROM Questionario q WHERE (q.nome LIKE %:filtro% OR q.descricao LIKE %:filtro%)")
    Page<Questionario> buscarQuestionarioPorFiltro(@Param("filtro") String filtro, Pageable pageable);

}
