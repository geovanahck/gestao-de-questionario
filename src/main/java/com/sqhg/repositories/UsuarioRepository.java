package com.sqhg.repositories;

import org.springframework.data.jpa.repository.Query;
import com.sqhg.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "select * from usuario where chaveDeAcesso = :chaveDeAcesso = :chaveDeAcesso", nativeQuery = true)
    public Usuario LoginUsuario(String chaveDeAcesso);
}
