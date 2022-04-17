package com.example.fortlommovile.backend.security.service;
import com.example.fortlommovile.backend.domain.model.entity.Person;
import com.example.fortlommovile.backend.domain.service.PersonService;
import com.example.fortlommovile.backend.security.Principal.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService{
    @Autowired
    PersonService personaService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person persona=personaService.getbyNombreUsuarioOrEmail(username).get();
        return UsuarioPrincipal.build(persona);
    }
}
