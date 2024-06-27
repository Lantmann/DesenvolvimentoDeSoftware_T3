package com.aplicativo.inscricoes.dto;

public class RegistrarPagamentoDTO {
    private Long assinaturaId;
    private Double valorPago;
    private String codigoPromocao;

    // Getters and Setters
    public Long getAssinaturaId() { return assinaturaId; }
    public void setAssinaturaId(Long assinaturaId) { this.assinaturaId = assinaturaId; }
    public Double getValorPago() { return valorPago; }
    public void setValorPago(Double valorPago) { this.valorPago = valorPago; }
    public String getCodigoPromocao() { return codigoPromocao; }
    public void setCodigoPromocao(String codigoPromocao) { this.codigoPromocao = codigoPromocao; }
}
