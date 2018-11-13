package com.chatpet.chatpetapi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "regras")
public class Regra {
    private Long id;
    private String nome;
    private Set<Usuario> usuarios;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToMany(mappedBy = "regras")
    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
