package com.sqhg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sqhg.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Page<Administrador> findByNome(String Param, Pageable pageable);
    
    @Query(value = "select * from administrador where cracha = :cracha and senha = :senha", nativeQuery = true)
    public Administrador Login(String cracha, String senha);

}
