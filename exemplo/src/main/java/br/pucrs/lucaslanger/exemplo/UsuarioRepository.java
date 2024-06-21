package br.pucrs.lucaslanger.exemplo;

import br.pucrs.lucaslanger.exemplo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Interface para operações CRUD em Usuario
}