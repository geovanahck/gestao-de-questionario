package com.sqhg.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sqhg.entities.Questionario;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {
}
