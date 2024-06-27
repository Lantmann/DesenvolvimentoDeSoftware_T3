package com.aplicativo.aplicativo.Helpers;

import com.suaempresa.subscriptions.dto.*;
import com.suaempresa.subscriptions.model.*;

import java.util.Date;

public class Helpers {

    // Converte um Cliente para um ClienteDTO
    public static ClienteDTO convertToClienteDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        return dto;
    }

    // Converte um ClienteDTO para um Cliente
    public static Cliente convertToClienteEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        return cliente;
    }

    // Converte um Aplicativo para um AplicativoDTO
    public static AplicativoDTO convertToAplicativoDTO(Aplicativo aplicativo) {
        AplicativoDTO dto = new AplicativoDTO();
        dto.setId(aplicativo.getId());
        dto.setNome(aplicativo.getNome());
        dto.setCustoMensal(aplicativo.getCustoMensal());
        return dto;
    }

    // Converte um AplicativoDTO para um Aplicativo
    public static Aplicativo convertToAplicativoEntity(AplicativoDTO aplicativoDTO) {
        Aplicativo aplicativo = new Aplicativo();
        aplicativo.setId(aplicativoDTO.getId());
        aplicativo.setNome(aplicativoDTO.getNome());
        aplicativo.setCustoMensal(aplicativoDTO.getCustoMensal());
        return aplicativo;
    }

    // Converte uma Assinatura para um AssinaturaDTO
    public static AssinaturaDTO convertToAssinaturaDTO(Assinatura assinatura) {
        AssinaturaDTO dto = new AssinaturaDTO();
        dto.setId(assinatura.getId());
        dto.setClienteId(assinatura.getCliente().getId());
        dto.setAplicativoId(assinatura.getAplicativo().getId());
        dto.setInicioVigencia(assinatura.getInicioVigencia());
        dto.setFimVigencia(assinatura.getFimVigencia());
        return dto;
    }

    // Converte uma AssinaturaDTO para uma Assinatura
    public static Assinatura convertToAssinaturaEntity(AssinaturaDTO assinaturaDTO) {
        Assinatura assinatura = new Assinatura();
        assinatura.setId(assinaturaDTO.getId());
        // Client and Application should be set from service layer to ensure they are managed entities
        assinatura.setInicioVigencia(assinaturaDTO.getInicioVigencia());
        assinatura.setFimVigencia(assinaturaDTO.getFimVigencia());
        return assinatura;
    }

    // Converte um Pagamento para um PagamentoDTO
    public static PagamentoDTO convertToPagamentoDTO(Pagamento pagamento) {
        PagamentoDTO dto = new PagamentoDTO();
        dto.setId(pagamento.getId());
        dto.setAssinaturaId(pagamento.getAssinatura().getId());
        dto.setValorPago(pagamento.getValorPago());
        dto.setDataPagamento(pagamento.getDataPagamento());
        return dto;
    }

    // Converte um PagamentoDTO para um Pagamento
    public static Pagamento convertToPagamentoEntity(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(pagamentoDTO.getId());
        // Assinatura should be set from service layer to ensure it is a managed entity
        pagamento.setValorPago(pagamentoDTO.getValorPago());
        pagamento.setDataPagamento(pagamentoDTO.getDataPagamento());
        return pagamento;
    }

    // Verifica se uma data está no futuro
    public static boolean isDateInFuture(Date date) {
        return date != null && date.after(new Date());
    }

    // Verifica se o e-mail é válido (exemplo básico)
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    // Verifica se o valor está dentro de um intervalo aceitável
    public static boolean isValueWithinRange(double value, double min, double max) {
        return value >= min && value <= max;
    }
}
