package com.chatpet.chatpetapi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {
    private Long id;
    private String email;
    private String senha;
    private String senhaConfirnacao;
    private Set<Regra> regras;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Transient
    public String getSenhaConfirnacao() {
        return senhaConfirnacao;
    }

    public void setSenhaConfirnacao(String senhaConfirnacao) {
        this.senhaConfirnacao = senhaConfirnacao;
    }

    @ManyToMany
    @JoinTable(name = "regra_usuario", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "regra_id"))
    public Set<Regra> getRegras() {
        return regras;
    }

    public void setRegras(Set<Regra> regras) {
        this.regras = regras;
    }
}
