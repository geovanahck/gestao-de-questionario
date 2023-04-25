package com.sqhg.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.sqhg.controllers.AdministradorController;
import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;
public class AdministradorControllerTest {
    
    private AdministradorRepository administradorRepository;
    private AdministradorController controller;

    @Before
    public void setUp() {
        administradorRepository = mock(AdministradorRepository.class);
        controller = new AdministradorController(administradorRepository);
    }

    @Test
    public void testFuncaoEditarAdministrador() {
        // given
        Administrador administrador = new Administrador();
        
        when(administradorRepository.buscarID(1)).thenReturn(administrador);

        // when
        ModelAndView modelAndView = controller.editarAdministrador(1);

        // assert
        assertEquals("editarAdm", modelAndView.getViewName());
        assertEquals(administrador, modelAndView.getModel().get("administrador"));
    }
}
