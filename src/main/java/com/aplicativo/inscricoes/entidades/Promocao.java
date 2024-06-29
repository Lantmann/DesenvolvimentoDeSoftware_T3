package com.aplicativo.inscricoes.entidades;

import jakarta.persistence.*;

@Entity
public class Promocao {
    @Id
    private long codigo;
    private String nome;
    private String tipo;
    private float valor;
    private Boolean ativa = true;

    public long getId() {return this.codigo;}

    public String getNome() {return this.nome;}

    public String getTipo() {return this.tipo;}

    public float getValor() {return this.valor;}

    public Boolean getAtiva() {return this.ativa;}

    public void setId(long codigo){ this.codigo = codigo;}

    public void setNome(String nome){ this.nome = nome;}

    public void setTipo(String tipo){ this.tipo = tipo;}

    public void setValor(float valor){ this.valor = valor;}

    public void setAtiva(Boolean ativa){ this.ativa = ativa;}

    } 

