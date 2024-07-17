package com.aluracursos.Challenge.foroHub.Challenge_ForoHub.infra.security;

import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.models.User;
import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticationService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado. Intentelo de nuevo");
        }
        return user;
    }
}
