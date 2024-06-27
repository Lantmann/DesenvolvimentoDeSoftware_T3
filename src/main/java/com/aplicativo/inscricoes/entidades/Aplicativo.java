package com.aplicativo.inscricoes.entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "aplicativos")
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false)
    private Double custoMensal;
}
