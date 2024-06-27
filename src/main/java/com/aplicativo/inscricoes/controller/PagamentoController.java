package com.aplicativo.aplicativo.Controllers;

import com.suaempresa.subscriptions.dto.PagamentoDTO;
import com.suaempresa.subscriptions.model.Pagamento;
import com.suaempresa.subscriptions.repository.PagamentoRepository;
import com.suaempresa.subscriptions.util.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<PagamentoDTO> getAllPagamentos() {
        return pagamentoRepository.findAll().stream()
                .map(Helpers::convertToPagamentoDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PagamentoDTO createPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = Helpers.convertToPagamentoEntity(pagamentoDTO);
        pagamento = pagamentoRepository.save(pagamento);
        return Helpers.convertToPagamentoDTO(pagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> getPagamentoById(@PathVariable Long id) {
        return pagamentoRepository.findById(id)
                .map(pagamento -> ResponseEntity.ok(Helpers.convertToPagamentoDTO(pagamento)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDTO> updatePagamento(@PathVariable Long id, @RequestBody PagamentoDTO pagamentoDTO) {
        return pagamentoRepository.findById(id).map(existingPagamento -> {
            existingPagamento.setValorPago(pagamentoDTO.getValorPago());
            existingPagamento.setDataPagamento(pagamentoDTO.getDataPagamento());
            pagamentoRepository.save(existingPagamento);
            return ResponseEntity.ok(Helpers.convertToPagamentoDTO(existingPagamento));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePagamento(@PathVariable Long id) {
        return pagamentoRepository.findById(id).map(pagamento -> {
            pagamentoRepository.delete(pagamento);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
