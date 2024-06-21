package br.pucrs.lucaslanger.exemplo;

import br.pucrs.lucaslanger.exemplo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Interface para operações CRUD em Cliente
}