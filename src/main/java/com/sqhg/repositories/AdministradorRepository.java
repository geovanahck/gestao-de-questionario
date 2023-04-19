package com.sqhg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sqhg.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    @Query(value = "SELECT * FROM administrador where cracha = :cracha and senha = :senha", nativeQuery = true)
    public Administrador Login(String cracha, String senha);

    @Query("SELECT a FROM Administrador a WHERE  a.ativo = true AND (a.cracha LIKE %:filtro% OR a.nome LIKE %:filtro% OR a.email LIKE %:filtro% OR a.telefone LIKE %:filtro%)")
    Page<Administrador> buscarAdministradoresPorFiltro(@Param("filtro") String filtro, Pageable pageable);


    @Query("SELECT a FROM Administrador a WHERE a.ativo = true")
    Page<Administrador> findAllActives(Pageable pageable);

    Administrador findById(long id);
}
