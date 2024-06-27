package com.aplicativo.inscricoes.dto;

import java.util.Date;

public class AssinaturaDTO {
    private Long id;
    private Long clienteId;
    private Long aplicativoId;
    private Date inicioVigencia;
    private Date fimVigencia;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getAplicativoId() { return aplicativoId; }
    public void setAplicativoId(Long aplicativoId) { this.aplicativoId = aplicativoId; }
    public Date getInicioVigencia() { return inicioVigencia; }
    public void setInicioVigencia(Date inicioVigencia) { this.inicioVigencia = inicioVigencia; }
    public Date getFimVigencia() { return fimVigencia; }
    public void setFimVigencia(Date fimVigencia) { this.fimVigencia = fimVigencia; }
}
