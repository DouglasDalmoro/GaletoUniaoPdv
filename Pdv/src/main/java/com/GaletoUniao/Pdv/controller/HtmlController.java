package com.GaletoUniao.Pdv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String Login() {
        return "TelaLogin";
    }

    @GetMapping("/home")
    public String telaInicial() {
        return "PaginaInicial";
    }

    @GetMapping("/cadastro-usuario")
    public String cadatroUsuario() {
        return "TelaCadastroUsuario";
    }

    @GetMapping("/registro-venda")
    public String registroVenda() {
        return "RegistroVenda";
    }

    @GetMapping("/cadastro-produtos")
    public String cadastroProduto() {
        return "CadastroProdutos";
    }
}
