package com.sqhg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sqhg.entities.Questionario;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
    @Query("SELECT q FROM Questionario q WHERE (q.nome LIKE %:filtro% OR q.descricao LIKE %:filtro% OR q.codigo LIKE %:filtro% OR q.administrador.nome LIKE %:filtro%)")
    Page<Questionario> acharQuestionariosPorPagina(@Param("filtro") String filtro, Pageable pageable);
}