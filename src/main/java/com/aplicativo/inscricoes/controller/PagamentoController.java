package com.aplicativo.inscricoes.controller;

import com.aplicativo.inscricoes.repository.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {
    private PagamentoRepository pagamentoRepository;

    public PagamentoController(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @GetMapping("")
    public String getMensagemInicial() {
        return "Central Dados Pagamento";
    }

    @GetMapping("/getId")
    public long getId() {
        return pagamentoRepository.findAll().getFirst().getId();
    }


    @GetMapping("/getAssinatura")
    public Long getAssinatura() {
        return pagamentoRepository.findAll().getFirst().getAssinatura().getId();
    }

    @GetMapping("/getValorPago")
    public float getValorPago() {
        return pagamentoRepository.findAll().getFirst().getvalorPago();
    }

    @GetMapping("/getDataPagamento")
    public Date getAlldataPagamento() {
        return pagamentoRepository.findAll().getFirst().getdataPagamento();
    }

    @GetMapping("/getPromocao")
    public String getAllPromocao() {
        return pagamentoRepository.findAll().getFirst().getPromocao().getNome();
    }
}
