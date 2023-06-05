package com.sqhg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sqhg.entities.Questionario;

@Repository
public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
    Questionario findById(long id);
}
