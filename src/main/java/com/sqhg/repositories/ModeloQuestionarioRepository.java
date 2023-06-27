package com.sqhg.repositories;

import com.sqhg.entities.ModeloQuestionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloQuestionarioRepository extends JpaRepository<ModeloQuestionario, Long> {

    @Query("SELECT mq FROM ModeloQuestionario mq WHERE (mq.nome LIKE %:filtro% OR mq.descricao LIKE %:filtro%)")
    Page<ModeloQuestionario> buscarModeloQuestionarioPorFiltro(@Param("filtro") String filtro, Pageable pageable);

}
