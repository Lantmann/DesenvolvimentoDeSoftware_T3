package com.aplicativo.inscricoes.dto;

import lombok.Data;

@Data
public class RegistrarPagamentoDTO {

    private Long assinaturaId;
    private Double valorPago;
    private String codigoPromocao;

}
