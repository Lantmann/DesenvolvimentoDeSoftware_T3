package com.aplicativo.inscricoes.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PagamentoDTO {

    private Long id;
    private Long assinaturaId;
    private Double valorPago;
    private Date dataPagamento;

}
