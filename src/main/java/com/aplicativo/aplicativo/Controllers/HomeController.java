package com.aplicativo.aplicativo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";  // Nome do template HTML que será renderizado
    }

    @GetMapping("/clientes")
    public String clientes(Model model) {
        return "clientes";
    }

    @GetMapping("/aplicativos")
    public String aplicativos(Model model) {
        return "aplicativos";
    }

    @GetMapping("/assinaturas")
    public String assinaturas(Model model) {
        return "assinaturas";
    }

    @GetMapping("/pagamentos")
    public String pagamentos(Model model) {
        return "pagamentos";
    }

    @GetMapping("/promocoes")
    public String promocoes(Model model) {
        return "promocoes";
    }
}
