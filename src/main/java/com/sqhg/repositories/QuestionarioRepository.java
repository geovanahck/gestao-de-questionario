package com.sqhg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqhg.entities.Questao;

public interface QuestionarioRepository extends JpaRepository<Questao, Long> {    

}
