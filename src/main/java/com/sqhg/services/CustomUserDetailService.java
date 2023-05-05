package com.sqhg.services;

import com.sqhg.entities.Administrador;
import com.sqhg.repositories.AdministradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private AdministradorRepository administradorRepository;

    @Override
    public UserDetails loadUserByUsername(String cracha) throws UsernameNotFoundException {
        Administrador administrador = administradorRepository.findByCracha(cracha);
        if (administrador != null) {
            return new User(
                    administrador.getCracha(),
                    administrador.getSenha(),
                    administrador.getAuthorities()
            );
        } else {
            throw new UsernameNotFoundException("Crachá inválido.");
        }
    }
}
