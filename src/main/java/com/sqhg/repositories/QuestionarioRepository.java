package com.sqhg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqhg.entities.Questionario;

import java.util.Optional;

public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
    Optional<Questionario> findByCodigo(Integer codigo);
}
