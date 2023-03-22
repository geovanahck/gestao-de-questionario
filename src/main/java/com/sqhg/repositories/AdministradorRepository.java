package com.sqhg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqhg.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    @Query(value="select * from administrador where email = :email and senha = :senha", nativeQuery = true);

        
}
