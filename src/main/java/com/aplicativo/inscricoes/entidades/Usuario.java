package com.aplicativo.inscricoes.entidades;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    private String usuario;
    private String senha;

    public String getNome() {return this.usuario;}

    public String getEmail() {return this.senha;}

    public void setNome(String usuario){ this.usuario = usuario;}

    public void setEmail(String senha){ this.senha = senha;}
}
