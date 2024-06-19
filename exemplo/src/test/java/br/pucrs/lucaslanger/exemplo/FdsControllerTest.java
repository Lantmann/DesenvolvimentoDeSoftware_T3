package br.pucrs.lucaslanger.exemplo;

import br.pucrs.lucaslanger.exemplo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FdsControllerTest {

    @LocalServerPort
    private int porta;

    @Autowired
    private TestRestTemplate restTemplate;

    private String urlBase;

    @BeforeEach
    public void setUp() {
        urlBase = "http://localhost:" + porta + "/servcad";
    }

    @Test
    public void testUsuarioValido() {
        Usuario usuario = new Usuario();
        usuario.setId(1L); // Assume que o usuário com ID 1 existe
        HttpEntity<Usuario> request = new HttpEntity<>(usuario);
        ResponseEntity<Boolean> response = restTemplate.exchange(urlBase + "/usuvalido", HttpMethod.POST, request, Boolean.class);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody());

        usuario.setId(999L); // Assume que o usuário com ID 999 não existe
        request = new HttpEntity<>(usuario);
        response = restTemplate.exchange(urlBase + "/usuvalido", HttpMethod.POST, request, Boolean.class);
        assertEquals(200, response.getStatusCodeValue());
        assertFalse(response.getBody());
    }

    @Test
    public void testObterClientes() {
        ResponseEntity<Cliente[]> response = restTemplate.getForEntity(urlBase + "/clientes", Cliente[].class);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().length > 0);
    }

    @Test
    public void testObterAplicativos() {
        ResponseEntity<Aplicativo[]> response = restTemplate.getForEntity(urlBase + "/aplicativos", Aplicativo[].class);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().length > 0);
    }
}