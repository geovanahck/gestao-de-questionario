package com.sqhg.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.ui.ExtendedModelMap;

import com.sqhg.entities.Administrador;

public class AdministradorControllerTest {

    private AdministradorController administradorController;

    @org.junit.jupiter.api.Test
    public void testTelaEditarAdministrador() {
        // Crie um objeto Model e um objeto AdministradorService para usar no teste
        ExtendedModelMap model = new ExtendedModelMap();

        // Defina o ID de um administrador existente para editar
        Long id = 1L;

        // Chame o método telaEditarAdministrador
        String resultado = administradorController.telaEditarAdministrador(model, id);

        // Verifique se o resultado é o esperado
        assertEquals("editarAdm", resultado);

        // Verifique se o objeto Administrador foi adicionado ao Model corretamente
        Administrador administrador = (Administrador) model.getAttribute("administrador");
        assertNotNull(administrador);
        assertEquals(id, administrador.getId());
    }

}
