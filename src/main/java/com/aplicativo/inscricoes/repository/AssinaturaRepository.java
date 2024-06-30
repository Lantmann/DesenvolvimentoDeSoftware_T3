package com.aplicativo.inscricoes.repository;

import com.aplicativo.inscricoes.entidades.Assinatura;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByFimVigenciaAfterOrFimVigenciaIsNull(LocalDate date);
    List<Assinatura> findByFimVigenciaBefore(LocalDate date);
    
    List<Assinatura> findByClienteId(Long clienteId);
}


