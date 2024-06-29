package com.aplicativo.inscricoes.dto;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

import com.aplicativo.inscricoes.entidades.Assinatura;

@Data
public class AssinaturaResponseDTO {
    private long codigoAssinatura;
    private long codigoCliente;
    private long codigoAplicativo;
    private Date dataInicio;
    private Date dataEncerramento;
    private String status;

    private AssinaturaResponseDTO convertToDto(Assinatura assinatura) {
        AssinaturaResponseDTO dto = new AssinaturaResponseDTO();
        dto.setCodigoAssinatura(assinatura.getId());
        dto.setCodigoCliente(assinatura.getCliente().getId());
        dto.setCodigoAplicativo(assinatura.getAplicativo().getId());
        dto.setDataInicio(assinatura.getInicioVigencia());
        dto.setDataEncerramento(assinatura.getFimVigencia());
        dto.setStatus(assinatura.getFimVigencia().after(Date.valueOf(LocalDate.now()))  ? "ATIVA" : "CANCELADA");
        return dto;
    }
}
