package com.aplicativo.inscricoes.entidades;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Assinatura {
    @Id
    private long codigo;

    @OneToOne
    @JoinColumn(name = "codigo_Aplicativo", nullable = false)
    private Aplicativo aplicativo;

    @OneToOne
    @JoinColumn(name = "codigo_Cliente", nullable = false)
    private Cliente codigo_Cliente;

    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;    

    public long getId() {return this.codigo;}

    public Aplicativo getAplicativo() {return this.aplicativo;}

    public Cliente getCliente() {return this.codigo_Cliente;}

    public LocalDate getInicioVigencia() {return this.inicioVigencia;}

    public LocalDate getFimVigencia() {return this.fimVigencia;}

    public void setId(long codigo) { this.codigo = codigo;}

    public void setAplicativo(Aplicativo aplicativo) { this.aplicativo = aplicativo;}

    public void setCliente(Cliente codigo_Cliente) { this.codigo_Cliente = codigo_Cliente;}

    public void setInicioVigencia(LocalDate inicioVigencia) { this.inicioVigencia = inicioVigencia;}

    public void setFimVigencia(LocalDate fimVigencia) { this.fimVigencia = fimVigencia;}


}
