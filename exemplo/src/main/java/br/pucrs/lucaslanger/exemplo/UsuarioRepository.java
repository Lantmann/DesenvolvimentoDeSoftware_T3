package br.pucrs.lucaslanger.exemplo;

import br.pucrs.lucaslanger.exemplo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Interface para operações CRUD em Usuario
}