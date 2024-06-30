package com.aplicativo.inscricoes.entidades;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Pagamento {
    @Id
    private long codigo;

    @OneToOne
    @JoinColumn(name = "codigo_Assinatura", nullable = false)
    private Assinatura assinatura;

    private float valorPago;
    private LocalDate dataPagamento;

    @OneToOne
    @JoinColumn(name = "promocao", nullable = true)
    private Promocao promocao;

    public long getId() {return this.codigo;}

    public Assinatura getAssinatura() {return this.assinatura;}

    public float getvalorPago() {return this.valorPago;}

    public LocalDate getdataPagamento() {return this.dataPagamento;}

    public Promocao getPromocao() {return this.promocao;}

    public void setCodigo(long codigo){ this.codigo = codigo;}

    public void setAssinatura(Assinatura assinatura){ this.assinatura = assinatura;}

    public void setValorPago(float valorPago){ this.valorPago = valorPago;}

    public void setDataPagamento(LocalDate dataPagamento) {this.dataPagamento = dataPagamento;}

    public void setPromocao(Promocao promocao){ this.promocao = promocao;}



}