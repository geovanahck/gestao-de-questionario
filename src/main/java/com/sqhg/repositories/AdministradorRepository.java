package com.sqhg.repositories;

import org.springframework.data.jpa.repository.Query;
import com.sqhg.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    @Query(value = "select * from administrador where email = :email and senha = :senha", nativeQuery = true)
    public Administrador Login(String email, String senha);

}
