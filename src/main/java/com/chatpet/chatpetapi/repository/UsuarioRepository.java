package com.chatpet.chatpetapi.repository;

import com.chatpet.chatpetapi.model.Regra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Regra, Long> {
}
