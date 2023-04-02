package com.sqhg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sqhg.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    @Query(value = "select * from administrador where cracha = :cracha and senha = :senha", nativeQuery = true)
    public Administrador Login(String cracha, String senha);

}

// @Repository
// public interface AdministradorRepository extends PagingAndSortingRepository<Administrador, Long> {
//     @Query(value = "select * from administrador", nativeQuery = true)
//     Page<Administrador> findAll(Pageable pageable);

//     public Administrador Login(String cracha, String senha);
// }
