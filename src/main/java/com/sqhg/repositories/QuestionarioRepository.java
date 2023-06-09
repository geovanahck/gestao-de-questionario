package com.sqhg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqhg.entities.Questionario;

public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
    Questionario findById(long id);
}
