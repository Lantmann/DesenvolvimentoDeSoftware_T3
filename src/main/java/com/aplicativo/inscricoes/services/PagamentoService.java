package com.aplicativo.inscricoes.services;

import com.aplicativo.inscricoes.dto.PagamentoDTO;
import com.aplicativo.inscricoes.dto.PagamentoResponseDTO;
import com.aplicativo.inscricoes.entidades.Assinatura;
import com.aplicativo.inscricoes.entidades.Pagamento;
import com.aplicativo.inscricoes.repository.AssinaturaRepository;
import com.aplicativo.inscricoes.repository.PagamentoRepository;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    private AssinaturaRepository assinaturaRepository;

    private PagamentoRepository pagamentoRepository;

    public PagamentoResponseDTO registrarPagamento(PagamentoDTO pagamentoDTO) {
        Assinatura assinatura = assinaturaRepository.findById(pagamentoDTO.getCodigo())
                .orElseThrow(() -> new RuntimeException("Assinatura não encontrada com o código fornecido."));

        double valorMensalidade = assinatura.getAplicativo().getCustoMensal();

       if (pagamentoDTO.getValorPago() != valorMensalidade) {
            return new PagamentoResponseDTO("VALOR_INCORRETO", null, pagamentoDTO.getValorPago());
        }
        LocalDate novaDataValidade = calcularNovaDataValidade(assinatura, pagamentoDTO.getDataPagamento());
        assinatura.setFimVigencia(novaDataValidade);
        assinaturaRepository.save(assinatura);

        Pagamento pagamento = new Pagamento();
        pagamento.setCodigo(pagamentoDTO.getCodigo());
        pagamento.setValorPago(pagamentoDTO.getValorPago());
        pagamento.setDataPagamento(pagamentoDTO.getDataPagamento());
        pagamentoRepository.save(pagamento);

        return new PagamentoResponseDTO("PAGAMENTO_OK", pagamentoDTO.getDataPagamento(), 0.0f);
    }

    private LocalDate calcularNovaDataValidade(Assinatura assinatura, LocalDate dataPagamento) {
        LocalDate fimVigenciaAtual = assinatura.getFimVigencia();

        if (fimVigenciaAtual == null || fimVigenciaAtual.isBefore(dataPagamento)) {
            return dataPagamento.plusDays(7);
        } else {
            return fimVigenciaAtual.plusDays(30);
        }
    }
}