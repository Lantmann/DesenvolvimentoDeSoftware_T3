package com.aplicativo.inscricoes.dto;

public class AplicativoDTO {
    private Long id;
    private String nome;
    private Double custoMensal;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getCustoMensal() { return custoMensal; }
    public void setCustoMensal(Double custoMensal) { this.custoMensal = custoMensal; }
}
