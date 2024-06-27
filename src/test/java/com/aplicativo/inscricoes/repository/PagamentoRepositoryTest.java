package com.aplicativo.inscricoes.repository;

import com.aplicativo.inscricoes.entidades.Pagamento;
import com.aplicativo.inscricoes.entidades.Assinatura;
import com.aplicativo.inscricoes.entidades.Cliente;
import com.aplicativo.inscricoes.entidades.Aplicativo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PagamentoRepositoryTest {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AplicativoRepository aplicativoRepository;

    private Pagamento pagamento1;
    private Pagamento pagamento2;
    private Assinatura assinatura;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente();
        cliente.setNome("John Doe");
        cliente.setEmail("john.doe@example.com");
        cliente = clienteRepository.save(cliente);

        Aplicativo aplicativo = new Aplicativo();
        aplicativo.setNome("App Pro");
        aplicativo.setCustoMensal(19.99);
        aplicativo = aplicativoRepository.save(aplicativo);

        assinatura = new Assinatura();
        assinatura.setCliente(cliente);
        assinatura.setAplicativo(aplicativo);
        assinatura.setInicioVigencia(new Date());
        assinatura.setFimVigencia(new Date());
        assinatura = assinaturaRepository.save(assinatura);

        pagamento1 = new Pagamento();
        pagamento1.setAssinatura(assinatura);
        pagamento1.setValorPago(100.0);
        pagamento1.setDataPagamento(new Date());

        pagamento2 = new Pagamento();
        pagamento2.setAssinatura(assinatura);
        pagamento2.setValorPago(200.0);
        pagamento2.setDataPagamento(new Date());

        pagamentoRepository.save(pagamento1);
        pagamentoRepository.save(pagamento2);
    }

    @Test
    void testFindAll() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();

        assertEquals(2, pagamentos.size());
    }

    @Test
    void testFindById() {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(pagamento1.getId());

        assertTrue(pagamento.isPresent());
        assertEquals(100.0, pagamento.get().getValorPago());
    }

    @Test
    void testSave() {
        Pagamento pagamento3 = new Pagamento();
        pagamento3.setAssinatura(assinatura);
        pagamento3.setValorPago(300.0);
        pagamento3.setDataPagamento(new Date());

        Pagamento savedPagamento = pagamentoRepository.save(pagamento3);

        assertNotNull(savedPagamento);
        assertEquals(300.0, savedPagamento.getValorPago());
    }

    @Test
    void testDeleteById() {
        pagamentoRepository.deleteById(pagamento1.getId());

        Optional<Pagamento> pagamento = pagamentoRepository.findById(pagamento1.getId());

        assertFalse(pagamento.isPresent());
    }
}
