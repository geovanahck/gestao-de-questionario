package com.sqhg.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sqhg.entities.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    @Query(value = "select * from administrador where cracha = :cracha and senha = :senha", nativeQuery = true)
    public Administrador Login(String cracha, String senha);
    
    
    // default Page<Administrador> findAdministradorByNamePage(String nome ,Pageable pageable) {
    //     Administrador Administrador = new Administrador();
    //     Administrador.setNome(nome);
        
    //     //se vai conter um valor , estamos configurando a pesquisa para consultar por partes do nome no banco de dados
    //     //igual a like com sql,  ignoreCase() vai ignorar maiusculo e minusculo e vai ser o nome
    //     ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
    //             .withMatcher("nome", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        
    //     //fazendo a união do objeto como o valor e a configuração para consultar 
    //     Example<Administrador> example = Example.of(Administrador, exampleMatcher);
        
    //     Page<Administrador> administradores = findAll(example, pageable);
        
    //     return administradores;
    // }
}