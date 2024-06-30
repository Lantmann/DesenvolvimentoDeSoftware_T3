package com.aplicativo.inscricoes.services;

import com.aplicativo.inscricoes.entidades.Usuario;
import com.aplicativo.inscricoes.repository.UsuarioRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario update(String nome, Usuario alteracoes){
        Usuario usuario = usuarioRepository.findById(nome).orElse(null);
        if(usuario != null){
            usuario.setNome(alteracoes.getNome());
            usuario.setSenha(alteracoes.getSenha());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public Usuario findByNome(String nome) {
        return usuarioRepository.findById(nome).orElse(null);
    }

    public void delete(String nome) {
        usuarioRepository.deleteById(nome);
    }

    public String allNome(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(Usuario::getNome)
                .collect(Collectors.joining("; "));
    }

    public List<Usuario> getAllObj() {
        return usuarioRepository.findAll();
    }

    public String getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(this::entidadeParaString)
                .collect(Collectors.joining("\n"));
    }

    private String entidadeParaString(Usuario usuario) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = usuario.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                sb.append(field.get(usuario)).append(" ");
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
