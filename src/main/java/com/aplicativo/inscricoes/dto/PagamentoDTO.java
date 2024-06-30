package com.aplicativo.inscricoes.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PagamentoDTO {
    private LocalDate dataPagamento;
    private Long codigo;
    private Float valorPago;
    private Long promocao;
}
