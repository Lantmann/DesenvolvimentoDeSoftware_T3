package br.pucrs.lucaslanger.exemplo;

import br.pucrs.lucaslanger.exemplo.Aplicativo;
import br.pucrs.lucaslanger.exemplo.Cliente;
import br.pucrs.lucaslanger.exemplo.Usuario;
import br.pucrs.lucaslanger.exemplo.AplicativoRepository;
import br.pucrs.lucaslanger.exemplo.ClienteRepository;
import br.pucrs.lucaslanger.exemplo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad") // Define a raiz da URL para os endpoints
public class Controller {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AplicativoRepository aplicativoRepository;

    // Endpoint POST /usuvalido
    @PostMapping("/usuvalido")
    public ResponseEntity<Boolean> usuarioValido(@RequestBody Usuario usuario) {
        // Verifica se o usuÃ¡rio existe no banco de dados
        boolean existe = usuarioRepository.existsById(usuario.getId());
        return ResponseEntity.ok(existe);
    }

    // Endpoint GET /clientes
    @GetMapping("/clientes")
    public List<Cliente> obterClientes() {
        // Retorna a lista de todos os clientes cadastrados
        return clienteRepository.findAll();
    }

    // Endpoint GET /aplicativos
    @GetMapping("/aplicativos")
    public List<Aplicativo> obterAplicativos() {
        // Retorna a lista de todos os aplicativos cadastrados
        return aplicativoRepository.findAll();
    }
}