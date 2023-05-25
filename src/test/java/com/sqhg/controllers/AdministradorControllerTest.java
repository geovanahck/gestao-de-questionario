package com.sqhg.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import com.sqhg.forms.AdministradorForm;
import com.sqhg.services.AdministradorService;

public class AdministradorControllerTest {
    @Mock
    private AdministradorService administradorService;

    @InjectMocks
    private AdministradorController administradorController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testeCadastrarAdministrador() {

        Model model = new BindingAwareModelMap();

        String result = administradorController.cadastrarAdministrador(model);

        assertEquals("cadAdministrador", result);

        // Verifique se o model contém o atributo "administrador" com uma instância de
        // AdministradorForm
        Object administrador = model.getAttribute("administrador");
        assertNotNull(administrador);
        assertTrue(administrador instanceof AdministradorForm);
    }

    @Test
    public void testeDeletarAdministrador() {
        Long id = 1L;

        String result = administradorController.deletarAdministrador(id);

        assertEquals("redirect:/administradores", result);

        verify(administradorService).deletar(id);
    }

}
