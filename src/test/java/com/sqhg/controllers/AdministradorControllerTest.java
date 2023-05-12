/*package com.sqhg.controllers;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdministradorControllerTest {

    private AdministradorRepository administradorRepository;
    private AdministradorController administradorController;

    @Before
    public void setUp() {
        administradorRepository = mock(AdministradorRepository.class);
        
    }

    @Test
    public void testFuncaoEditarAdministrador() throws IllegalAccessException {
        // given
        Administrador administrador = new Administrador();
        long id = 1;
        when(administradorRepository.findById(id)).thenReturn(Optional.of(administrador));

        // when
        ModelAndView modelAndView = administradorController.irParaTelaAdministrador(1, null, administrador);

        // assert
        assertEquals("editarAdm", modelAndView.getViewName());
        assertEquals(administrador, modelAndView.getModel().get("administrador"));
    }
}
*/