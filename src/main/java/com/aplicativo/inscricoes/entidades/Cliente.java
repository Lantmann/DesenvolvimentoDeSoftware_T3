package com.aplicativo.inscricoes.entidades;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    private long codigo;
    private String nome;
    private String email;

    public long getId() {return this.codigo;}

    public String getNome() {return this.nome;}

    public String getEmail() {return this.email;}

    public void setId(long codigo){ this.codigo = codigo;}

    public void setNome(String nome){ this.nome = nome;}

    public void setEmail(String email){ this.email = email;}

}
