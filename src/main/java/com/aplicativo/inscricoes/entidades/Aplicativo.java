package com.aplicativo.inscricoes.entidades;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
//@Table(name = "aplicativos")
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double custoMensal;

    @OneToMany(mappedBy = "aplicativo")
    private List<Assinatura> assinaturas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
