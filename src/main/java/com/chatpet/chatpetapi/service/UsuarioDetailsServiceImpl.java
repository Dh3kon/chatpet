package com.chatpet.chatpetapi.service;

import com.chatpet.chatpetapi.model.Regra;
import com.chatpet.chatpetapi.model.Usuario;
import com.chatpet.chatpetapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Regra regra : usuario.getRegras()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(regra.getNome()));
        }
        return new User(usuario.getEmail(), usuario.getSenha(), grantedAuthorities);
    }
}
