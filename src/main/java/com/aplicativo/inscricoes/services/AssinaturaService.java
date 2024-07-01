package com.aplicativo.inscricoes.services;

import com.aplicativo.inscricoes.entidades.Assinatura;
import com.aplicativo.inscricoes.repository.AssinaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    public Assinatura create(Assinatura assinatura) {
        return assinaturaRepository.save(assinatura);
    }

    public Assinatura update(Long id, Assinatura alteracoes) {
        Assinatura assinatura = assinaturaRepository.findById(id).orElse(null);
        if (assinatura != null) {
            assinatura.setAplicativo(alteracoes.getAplicativo());
            assinatura.setCliente(alteracoes.getCliente());
            assinatura.setInicioVigencia(alteracoes.getInicioVigencia());
            assinatura.setFimVigencia(alteracoes.getFimVigencia());
            return assinaturaRepository.save(assinatura);
        }
        return null;
    }

    public Assinatura findById(Long id) {
        return assinaturaRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        assinaturaRepository.deleteById(id);
    }

    public List<Assinatura> getAll() {
        return assinaturaRepository.findAll();
    }

    public List<Assinatura> getAssinaturasPorTipo(String tipo) {
        LocalDate now = LocalDate.now();
        if (tipo.equalsIgnoreCase("ATIVAS")) {
            return assinaturaRepository.findByFimVigenciaAfterOrFimVigenciaIsNull(now);
        } else if (tipo.equalsIgnoreCase("CANCELADAS")) {
            return assinaturaRepository.findByFimVigenciaBefore(now);
        } else {
            return assinaturaRepository.findAll();
        }
    }
}