package br.pucrs.lucaslanger.exemplo;

import br.pucrs.lucaslanger.exemplo.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {
    // Interface para operações CRUD em Aplicativo
}