package com.aplicativo.inscricoes.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AssinaturaDTO {

    private Long id;
    private Long clienteId;
    private Long aplicativoId;
    private Date inicioVigencia;
    private Date fimVigencia;

}
