package com.aplicativo.inscricoes.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "assinaturas")
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aplicativo_id", nullable = false)
    private Aplicativo aplicativo;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date inicioVigencia;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fimVigencia;
}
