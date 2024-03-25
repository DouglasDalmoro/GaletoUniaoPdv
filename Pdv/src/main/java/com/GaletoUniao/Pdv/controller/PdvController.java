package com.GaletoUniao.Pdv.controller;

import com.GaletoUniao.Pdv.controller.request.*;
import com.GaletoUniao.Pdv.controller.response.*;
import com.GaletoUniao.Pdv.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/")
public class PdvController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CadastrarProdutoService cadastrarProdutoService;

    @Autowired
    private ListarProdutosService listarProdutosService;

    @Autowired
    private CadastrarQuartoService cadastrarQuartoService;

    @Autowired
    private ListarQuartosService listarQuartosService;

    @Autowired
    private CadastrarHospedagemService cadastrarHospedagemService;

    @Autowired
    private ListarHospedagemService listarHospedagemService;

    @Autowired
    private DetalharHospedagemService detalharHospedagemService;

    @Autowired
    private FinalizarHospedagemService finalizarHospedagemService;

    @Autowired
    private ExcluirHospedagemService excluirHospedagemService;

    @Autowired
    private CadastrarVendaService cadastrarVendaService;

    @Autowired
    private ListarVendaService listarVendaService;

    @Autowired
    private FinalizarVenda finalizarVenda;

    @Autowired
    private ExcluirVendaService excluirVendaService;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody CadastrarUsuarioRequest request) {
        cadastrarUsuarioService.cadastrar(request);
    }

    @PostMapping("/login")
    public UsuarioResponse login(@RequestBody LoginReques reques) {
        return loginService.login(reques);
    }

    @PostMapping("/produto/cadastrar")
    public void cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {
        cadastrarProdutoService.cadastrar(produtoRequest);
    }

    @GetMapping("/produtos/listar")
    public Page<ProdutoResponse> listarProdutos(Pageable pageable){
        return listarProdutosService.listar(pageable);
    }

    @PostMapping("/quarto/cadastrar")
    public void cadastrar(@RequestBody QuartoRequest request) {
        cadastrarQuartoService.cadastrar(request);
    }

    @GetMapping("/quarto/listar")
    public Page<QuartoResponse> listarHospedagem(Pageable pageable){
        return listarQuartosService.listar(pageable);
    }

    @PostMapping("/hospedagem/registrar")
    public void cadastrar(@RequestBody HospedagemRequest request) {
        cadastrarHospedagemService.cadastrar(request);
    }

    @GetMapping("/hospedagem/listar")
    public Page<HospedagemResponse> listar(Pageable pageable) {
        return listarHospedagemService.listar(pageable);
    }

    @GetMapping("/hospedagem/listar-ativas")
    public Page<HospedagemResponse> listarAtivas(Pageable pageable) {
        return listarHospedagemService.listarAtivas(pageable);
    }

    @GetMapping("/hospedagem/{id}")
    public HospedagemResponse detalhar(@PathVariable Long id) {
        return detalharHospedagemService.detalhar(id);
    }

    @PutMapping("/hospedagem/{id}/finalizar")
    public void finalizar(@PathVariable Long id) {
        finalizarHospedagemService.finalizar(id);
    }

    @DeleteMapping("/hospedagem/{id}/excluir")
    public void excluirHospedagem(@PathVariable Long id) {
        excluirHospedagemService.excluir(id);
    }

    @PostMapping("/venda/cadastrar")
    public void cadastrarVenda(@RequestBody CadastrarVendaRequest cadastrarVendaRequest){
        cadastrarVendaService.cadastrar(cadastrarVendaRequest);
    }

    @GetMapping("/venda/listar")
    public Page<VendaResponse> listarVendas(Pageable pageable) {
        return listarVendaService.listar(pageable);
    }

    @PutMapping("/venda/{id}/finalizar")
    public void finalizarVenda(@PathVariable Long id) {
        finalizarVenda.finalizar(id);
    }

    @DeleteMapping("/venda/{id}/excluir")
    public void excluir(@PathVariable Long id) {
        excluirVendaService.excluir(id);
    }
}
