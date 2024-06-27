package com.aplicativo.aplicativo.Service;

import com.suaempresa.subscriptions.model.Assinatura;
import com.suaempresa.subscriptions.repository.AssinaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    public List<Assinatura> findAll() {
        return assinaturaRepository.findAll();
    }

    public Optional<Assinatura> findById(Long id) {
        return assinaturaRepository.findById(id);
    }

    public Assinatura save(Assinatura assinatura) {
        return assinaturaRepository.save(assinatura);
    }

    public void deleteById(Long id) {
        assinaturaRepository.deleteById(id);
    }
}
