package com.chatpet.chatpetapi.repository;

import com.chatpet.chatpetapi.model.Regra;
import com.chatpet.chatpetapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
