package com.aplicativo.inscricoes.entidades;

import jakarta.persistence.*;

@Entity
public class Aplicativo {
    @Id
    private long codigo;
    private String nome;
    private float custo_Mensal;

    public long getId() {return this.codigo;}
    
    public float getCustoMensal() {return this.custo_Mensal;}

    public String getNome() {return this.nome;}

    public void setId(long codigo){ this.codigo = codigo;}
    
    public void setCustoMensal(float custoMensal){ this.custo_Mensal = custo_Mensal;}

    public void setNome(String nome){ this.nome = nome;}


}
