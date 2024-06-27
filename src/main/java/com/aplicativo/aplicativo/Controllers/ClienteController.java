package com.aplicativo.aplicativo.Controllers;

import com.suaempresa.subscriptions.dto.ClienteDTO;
import com.suaempresa.subscriptions.model.Cliente;
import com.suaempresa.subscriptions.repository.ClienteRepository;
import com.suaempresa.subscriptions.util.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.findAll().stream()
                .map(Helpers::convertToClienteDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ClienteDTO createCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = Helpers.convertToClienteEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return Helpers.convertToClienteDTO(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> ResponseEntity.ok(Helpers.convertToClienteDTO(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        return clienteRepository.findById(id).map(existingCliente -> {
            existingCliente.setNome(clienteDTO.getNome());
            existingCliente.setEmail(clienteDTO.getEmail());
            clienteRepository.save(existingCliente);
            return ResponseEntity.ok(Helpers.convertToClienteDTO(existingCliente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        return clienteRepository.findById(id).map(cliente -> {
            clienteRepository.delete(cliente);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
