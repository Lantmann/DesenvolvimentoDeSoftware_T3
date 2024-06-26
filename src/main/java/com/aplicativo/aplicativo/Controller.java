package com.aplicativo.aplicativo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aplicativo.aplicativo.dbFinder;
import java.util.List;

@RestController
@RequestMapping("/servcad")
public class Controller {

    @PostMapping("/usuvalido")
    public ResponseEntity<Boolean> usuarioValido(@RequestBody Usuario usuario) {
        Boolean existe = false;
        if(dbFinder.selectCodigo("Usuario", "usuario", String.valueOf(usuario.getId()))!=null){existe = true;}
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/clientes")
    public List<String> obterClientes() {
        return dbFinder.selectList("Clientes", "codigo");
    }

    @GetMapping("/teste")
    public String getString() {
        return "wasd";
    }

    @GetMapping("/aplicativos")
    public List<String> obterAplicativos() {
        return dbFinder.selectList("Aplicativo", "nome");
    }
}