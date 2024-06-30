package com.aplicativo.inscricoes.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PagamentoResponseDTO {
    private String status;
    private LocalDate data;
    private Float valorEstornado;

    public PagamentoResponseDTO(String status, LocalDate data, Float valorEstornado) {
        this.status = status;
        this.data = data;
        this.valorEstornado = valorEstornado;
    }

    public PagamentoResponseDTO(String status, Object data, Float valorEstornado) {
        this.status = status;
        this.data = null;
        this.valorEstornado = valorEstornado;
    }
}