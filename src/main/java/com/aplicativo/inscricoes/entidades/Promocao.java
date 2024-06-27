package com.aplicativo.inscricoes.entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "promocoes")
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false)
    private Double desconto;  // Assuming percentage
}
