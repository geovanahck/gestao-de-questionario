package com.sqhg.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqhg.entities.Opcao;

public interface OpcaoRepository extends JpaRepository<Opcao, Long> {
    List<Opcao> findByQuestaoId(Long questaoId);
}
