package com.sqhg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sqhg.entities.SuperiorImediato;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionarioRepository extends JpaRepository<SuperiorImediato, Long> {
    List<SuperiorImediato> findByAreaNomeInAndCargoIn(List<String> areas, List<String> cargos);
}
