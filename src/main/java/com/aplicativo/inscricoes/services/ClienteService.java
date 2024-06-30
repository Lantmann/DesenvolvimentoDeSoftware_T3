package com.aplicativo.inscricoes.services;

import com.aplicativo.inscricoes.entidades.Cliente;
import com.aplicativo.inscricoes.repository.ClienteRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente alteracoes) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNome(alteracoes.getNome());
            cliente.setEmail(alteracoes.getEmail());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public String allId() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> String.valueOf(cliente.getId()))
                .collect(Collectors.joining("; "));
    }

    public String allNome() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(Cliente::getNome)
                .collect(Collectors.joining("; "));
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public String getAllCampos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(this::entidadeParaString)
                .collect(Collectors.joining("\n"));
    }

    private String entidadeParaString(Cliente cliente) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = cliente.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                sb.append(field.get(cliente)).append(" ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}